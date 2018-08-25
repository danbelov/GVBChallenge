<?php

    $json = file_get_contents("https://7ed86656-f226-49a4-ad3f-9676893cc520.mock.pstmn.io/DamageReport");
    $reports = json_decode($json);

    $id = $_GET["id"];

    echo "<!--";
    echo $json;
    echo "-->";

    $mainReport = null;
    foreach($reports as $r)
        if($r->id == $id)
            $mainReport = $r;
    
?>

<!doctype html>

<html lang="en">
<head>
    <meta charset="utf-8">

    <title>The HTML5 Herald</title>
    <meta name="description" content="Super gvb schadensmeldung">
    <meta name="author" content="Unser teamname">
    <meta http-equiv="Cache-Control" content="no-store" />

    <link rel="stylesheet" href="static/main.css?v=1.0">
    <script src="static/main.js"></script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<div class="row">
    <aside class="col-sm-4 list-group">

    <div class="menu-item border">
        <h5>Schadensmeldungen</h5>
    </div>

    <?php
    foreach($reports as $r){

        $link="overview.php?id=" . $r->id;

        ?>
        
            <div class="menu-item border <?php if($id == $r->id) echo 'active' ?>">
                <a href="<?php echo $link; ?>">
                    <div class="row">
                    <p class="col-sm-6"><?php echo $r->name;?></p>
                    <p class="col-sm-6"><small><?php echo $r->status;?></small></p>
                    </div>
                </a>
            </div>
        <?php
    }?>
    </aside>

    <main class="report-container col-sm-8">

            <?php if($mainReport){ ?>
                
                
                <h2>Übersicht Nr. <?php echo $mainReport->id?></h2>

            <table class="table">
                <tbody>
                    <tr>
                        <td>Status</td>
                        <td><span class="badge badge-secondary"><?php echo $mainReport->status;?></span></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><?php echo $mainReport->name;?></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><?php echo $mainReport->email;?></td>
                    </tr>
                    <tr>
                        <td>Police Nr:</td>
                        <td><?php echo $mainReport->policeNr;?></td>
                    </tr>
                    <tr>
                        <td>Schadensdatum</td>
                        <td><?php echo $mainReport->damageDate;?></td>
                    </tr>
                    <tr>
                        <td>Schadensursache</td>
                        <td><?php echo $mainReport->damageSource;?></td>
                    </tr>
                </tbody>
            </table>

            <h2>Schaden</h2>

            
        <p></p>
        <p></p>
        <p></p>
        <p></p>

            <table class="table">
                <tbody>
                    <tr>
                        <td>Offerete existiert</td>
                        <td><?php echo $mainReport->offerExists;?></td>
                    </tr>
                    <tr>
                        <td>Schadenssumme</td>
                        <td><?php echo $mainReport->costs;?></td>
                    </tr>
                    <tr>
                        <td>Selbsteinschätzung</td>
                        <td><?php echo $mainReport->selfEstimated;?></td>
                    </tr>
                    <tr>
                        <td>Rechnung existiert</td>
                        <td><?php echo $mainReport->billExists;?></td>
                    </tr>
                </tbody>
            </table>

            <h3>Beschädigtes Elemente</h3>
            <table class="table">
                <tbody>
                    <?php foreach($mainReport->damagedItems as $item){ ?>
                    <tr>
                        <td><?php echo $item ?></td>
                    </tr>
                    <?php } ?>
                </tbody>
            </table>

        <h3>Schadenshergang</h3>
        <p><?php echo $mainReport->damageDescription;?></p>

        <h3>Weitere Informationen</h3>
        <p><?php echo $mainReport->otherInformations;?></p>

        <h2>Verlauf</h2>
        <div class="eventscontainer">
            <?php
            foreach($mainReport->events as $event){?>
             
                <div class="event border border-round">
                    <div class="row">
                        <p class="col-sm-2"><?php echo $event->time;?></p>
                        <p class="col-sm-10"><?php echo $event->text;?></p>
                    </div>
                </div>

            <?php }?>
        </div>

        <h2>Bilder</h2>
        <div class="imagescontainer">
            <?php
            foreach($mainReport->images as $img){?>
             
                <div class="image">
                    <img src="<?php echo $img->url;?>"/>
                    <p><?php echo $img->description;?></p>
                </div>

            <?php }?>
        </div>

            <?php }?>
        </main>

</div>
</body>
</html>

