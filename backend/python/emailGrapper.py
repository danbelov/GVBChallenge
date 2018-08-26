# -*- coding: utf-8 -*-
"""
Created on Sat Aug 25 00:10:17 2018

@author: Christian
"""
import time
import imaplib
import requests
import email

ORG_EMAIL   = "@gmail.com"
FROM_EMAIL  = "gvbschaden" + ORG_EMAIL
FROM_PWD    = "gvbhack18"
SMTP_SERVER = "imap.gmail.com"
SMTP_PORT   = 993

# -------------------------------------------------
#
# Utility to read email from Gmail Using Python
#
# ------------------------------------------------

def read_email_from_gmail():
    try:
        mail = imaplib.IMAP4_SSL(SMTP_SERVER)
        mail.login(FROM_EMAIL,FROM_PWD)
        mail.list()
        mail.select('inbox')

        result, data = mail.uid('search', None, "ALL") # search and return uids instead
        email_ids = data[0].split()
       
        for email_id in email_ids:
            result, data = mail.uid('fetch', email_id, '(RFC822)')
            raw_email = data[0][1]
            msg = email.message_from_bytes(raw_email)
            name, mailaddr = email.utils.parseaddr(msg['From'])
            if msg.is_multipart():
                body = email.iterators.body_line_iterator(msg, decode=False)
            else:
                body = msg.get_payload()
                
            rst = requests.post("http://142.93.107.12:9000/email", data={'sender':mailaddr,'msg':body})
            print(rst)
            mail.uid('store', email_id,'+X-GM-LABELS', '\\Trash')
        
        mail.expunge()
        mail.close()
        mail.logout()

    except RuntimeError:
        print("Exception!!!")
        
if __name__ == '__main__':
   while true:
       read_email_from_gmail()
       time.sleep(1)
       
       
