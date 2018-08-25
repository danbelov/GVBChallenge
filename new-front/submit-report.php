<?php
    $id = 12;
?>
<!doctype html>

<html lang="en">
<head>
    <meta charset="utf-8">

    <title>GVB Schadensmeldung</title>
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
                <h1>Willkommen!</h1>
                <p>Schön das Sie einen Schaden habe, um was geht es?</p>

                <div class="row damage-types-container">
                    <div class="col-sm-4"><div class="damage-type-card">Blitzschlag direkt</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Einbruchdiebstahl</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Erdrutsch</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Fahrzeuganprall</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Feuer</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Gebäudeeinsturz</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Gebäudetechnik</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Glasbruch</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Grund-/Hangwasser</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Hagel</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Hochwasser</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Lawine</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Leitungsbruch</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Marder-, Nager, Insekten</div></div>
                    <!--<div class="col-sm-4"><div class="damage-type-card">Regen-, Schnee-, Schmelzwasser</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Risse in Fassade</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Schneedruck</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Solaranlage: Beschädigung/Zerstörung/ Diebstahl Anlage </div></div>
                    <div class="col-sm-4"><div class="damage-type-card">elektrische Überspannung bei Gewitter</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Steinschlag</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Sturmwind</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Vandalismus</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Wasser: Frost</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Wasser: Rückstau</div></div>
                    <div class="col-sm-4"><div class="damage-type-card">Überschwemmung</div></div>-->
                </div>

                <div class="left-bottom-corner">
                    <p>Es geht um etwas anderes:</p>
                    <input type="text" class="form-control" placeholder="Schadensgrund"/>
                </div>
                
                <input type="hidden" name="damageSource" id="input-damageSource" value="" />
                <button class="btn" type="button" onclick="next('.container-second');">Weiter</button>
        </div>
        <div class="container container-second">

                <h1>Was ist passiert?</h1>
                <p>Beschreiben Sie möglichst detailiert was passiert ist</p>

                <textarea class="form-control" rows="10" id="damageDescription"></textarea>
                <button class="btn btn-default" type="button" onclick="next('.container-third');">Weiter</button>
        </div>
        <div class="container container-third">

                <h1>Fotos?</h1>
                <p>Wenn Sie ein Foto von dem schaden haben laden Sie dieses bitte hoch</p>

                <iframe height="200" width="500" src="upload.php">
                    
                </iframe>

                <button class="btn" type="button" onclick="next('.container-questions');">Weiter</button>
        </div>
        <div class="container container-upload" style="display: none;">
                <label>Bitte laden Sie das Foto auf den Server</label>
                    <button class="btn btn-success" type="button" onclick="next('.container-third');">Zurück</button>
                    <button class="btn btn-success" type="button" onclick="next('.container-questions');">Ja</button>
                    <button class="btn btn-danger" type="button" onclick="next('.container-questions');">Nein</button>
                
                <button class="btn btn-default" type="button" onclick="next('.container-questions');">Weiter</button>
        </div>
        <div class="container container-questions" style="display: none;">
            <h1>Bitte teilen sie uns noch die folgende information mit:</h1>
            <label>Versicherungsnummer</label>
            <input type="text" >
            <input type="submit" >
        </div>
    </div>
    </form>
</body>
</html>