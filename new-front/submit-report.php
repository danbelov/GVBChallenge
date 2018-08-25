<?php
    $id = $_GET["id"];
    $email= $_GET["email"];

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {

        $obj = new stdClass();
        $obj->id = $_POST["id"];
        $obj->status = "Waiting for support";
        $obj->policeNr = $_POST["policeNr"];
        $obj->name = $_POST["name"];
        $obj->email = email;
        $obj->damageDate = $_POST["damageDate"];
        $obj->damageSource = $_POST["damageSource"];
        $obj->damagedItems = $_POST["damagedItems"];
        $obj->damageDescription = $_POST["damageDescription"];
        $obj->otherInformations = $_POST["otherInformations"];
        $obj->offerExists = $_POST["offerExists"];
        $obj->costs = $_POST["costs"];
        $obj->selfEstimated = $_POST["selfEstimated"];
        $obj->costs = $_POST["costs"];
        $obj->billExists = $_POST["billExists"];

        $jsonString = json_encode($obj);

        /*{
        "id": 214,
        "status": "WaitingForCustomer",
        "fraudScore": 0.123,
        "policeNr": "12312-12",
        "name": "Peter Beispiel",
        "email": "peter@beispiel.ch",
        "damageDate": "Datum des Ereignisses",
        "damageSource": "Schadenshergang",
        "damagedItems": [
            "Dach",
            "Keller"
        ],
        "damageDescription": "Etwas ist kapputgegangen",
        "otherInformations": "blablabla",
        "offerExists": true,
        "costs": 2323.12,
        "selfEstimated": false,
        "billExists": true}
        */


        var_dump($jsonString);

        $curl = curl_init();

        curl_setopt_array($curl, array(
        CURLOPT_URL => "http://142.93.107.12:9000/DamageReport",
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_ENCODING => "",
        CURLOPT_MAXREDIRS => 10,
        CURLOPT_TIMEOUT => 30,
        CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
        CURLOPT_CUSTOMREQUEST => "PUT",
        CURLOPT_POSTFIELDS => $jsonString,
        CURLOPT_HTTPHEADER => array(
            "Content-Type: application/json"
        ),
        ));

        $response = curl_exec($curl);
        $err = curl_error($curl);

        curl_close($curl);

        if ($err) {
        echo "cURL Error #:" . $err;
        } else {
        echo $response;
        }

        exit();
    }
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
    <form method="post" id="theoneandonlyform">

    <input type="hidden" name="id" value="<?php echo $id ?>" />
    <input type="hidden" name="damageDate" value="" />
    <input type="hidden" name="damagedItems" value="" />
    <input type="hidden" name="otherInformations" value="" />
    <input type="hidden" name="offerExists" value="" />
    <input type="hidden" name="selfEstimated" value="" />
    <input type="hidden" name="billExists" value="" />

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
        <div class="container container-second" style="">

                <h1>Was ist passiert?</h1>
                <p>Beschreiben Sie möglichst detailiert was passiert ist</p>

                <textarea class="form-control" rows="10" id="damageDescription" name="damageDescription" form="theoneandonlyform"></textarea>
                <button class="btn btn-default" type="button" onclick="next('.container-third');">Weiter</button>
        </div>
        <div class="container container-third">

                <h1>Fotos?</h1>
                <p>Wenn Sie ein Foto von dem schaden haben laden Sie dieses bitte hoch</p>

                <iframe height="200" width="500" src="upload.php">
                    
                </iframe>

                <button class="btn" type="button" onclick="next('.container-questions');">Weiter</button>
        </div>
        <div class="container container-questions" style="">
                <h1>Bitte teilen sie uns noch die folgende Informationen mit:</h1>
                <label>Versicherungsnummer</label>
                <input type="text" name="policeNr">
                <label>Name Vorname</label>
                <input type="text" name="name">
                <label>Adresse</label>
                <input type="text" name="address">
                <label>Wie gross ist die Schadenssumme?</label>
                <input type="text" name="costs">
                <input type="submit" value="Definitiv einreichen">
        </div>
    </div>
    </form>
</body>
</html>