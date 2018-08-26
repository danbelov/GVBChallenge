import glob
import re
import csv

files = glob.glob("files/reports/*.txt")

damageOrigins = set()
reports = []

for fname in files:
    with open(fname) as f:
        content = f.readlines()

        report = {}

        for line in content:
            m = re.search('(.+): (.+)', line)
            if m is not None:
                report[m.group(1)] = m.group(2)

    reports.append(report)

for r in reports:
    if "Schadensursache" in r:
        ursache = r["Schadensursache"]
        r[ursache] = 1
      
allKeys = set()
for r in reports:
    keys = r.keys()
    for k in keys:
        allKeys.add(k)
    
    

with open("reports.csv", "w") as csv_file:
        writer = csv.DictWriter(csv_file, fieldnames=allKeys)

        writer.writeheader()

        for r in reports:
            writer.writerow(r)

#print(allKeys)
#print(reports)
#print(damageOrigins)