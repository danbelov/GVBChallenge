<!doctype html>

<html lang="en">
<head>
    <meta charset="utf-8">

    <title>The HTML5 Herald</title>
    <meta name="description" content="Super gvb schadensmeldung">
    <meta name="author" content="Unser teamname">
    <meta http-equiv="Cache-Control" content="no-store" />

    <link rel="stylesheet" href="static/main.css?v=1.0">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


    <script src="/static/submitform.js"></script>

</head>
<body>

    <form action="/submit" method="post">
    <div class="container-holder">
        <div class="container container-first">
                <label for=""></label>
                <input type = "text" name =""/>
                <select>
                    <option id="1" name="">
                    <option id="2" name="">
                </select>
                <button type="button" onclick="next('.container-second');">Weiter</button>
        </div>
        <div class="container container-second">
                <label for="" text="Was ist passiert?"></label>
                <input type = "text" name ="">
                <textarea>

                </textarea>

                <button type="button">Weiter</button>
        </div>
        <div class="container container-third">
                <label for="" text="Haben sie ein photo?"></label>
                    <input type = "submit" name ="negative" text="no">
                    <input type = "submit" name ="positive" text="yes">
                <textarea>
                    
                </textarea>

                <button type="button">Weiter</button>
        </div>
        <div class="container container-upload">
                <label text="Bitte laden Sie das Foto auf den Server"></label>
                    <input type = "" name ="negative" text="no">
                <textarea>
                    
                </textarea>

                <button type="button">Weiter</button>
        </div>
        <div class="container container-questions">
            <h1>Bitte teilen sie uns noch die folgende information mit:</h1>
            <label>Versicherungsnummer</label>
            <input type="text" >
        </div>
    </div>
    </form>
</body>
</html>