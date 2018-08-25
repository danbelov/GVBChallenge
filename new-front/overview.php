<?php
    $json = file_get_contents("http://142.93.107.12:9000/DamageReport");
    $reports = json_decode($json);

    $id = $_GET["id"];

    echo "<!--";
    echo $json;
    echo "-->";

    $mainReport = null;
    foreach($reports as $r)
        if($r->id == $id)
            $mainReport = $r;

      if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        if (isset($_POST['status']) && isset($_POST['id'])){
          ChangeState($_POST['status'],$id);
        }
      }

    function changeState($status,$id){
      $url = 'http://142.93.107.12:9000/ChangeStatus/'.$id;
      $data = array("status" => $status);
      $data_string = json_encode($data);

      $ch = curl_init($url);
      curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
      curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
      curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
      curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/json',
        'Content-Length: ' . strlen($data_string))
      );
      $result = curl_exec($ch);
    }

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

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

</head>
<body>
<div class="row">

    <?php if($_GET["admin"]) { ?>
  <aside class="col-sm-4 list-group">
    <h5>Schadensmeldungen</h5>
    <script>$(document).ready( function () {

     $('#table').DataTable();

     $('#table').delegate('tbody > tr', 'click', function ()
     {
      let tr = $(this);
      let url = tr.data('url');
        // 'this' refers to the current <td>, if you need information out of it
        window.location.replace(url)
      });
    } );

    </script>

    <table id="table" class="display hover">
        <thead>
            <tr>
                <th>Name</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
          <?php foreach($reports as $r){

            $link="overview.php?id=" . $r->id;
            ?>
            <tr data-url="<?php echo $link; ?>">
              <!-- <a href="<?php echo $link; ?>"> -->
                <td><?php echo $r->name;?></td>
                <td><?php echo $r->status;?></td>
            </tr>
          <?php } ?>
        </tbody>
    </table>

    </aside><?php } ?>


    <main class="report-container col-sm-8">

            <?php if($mainReport){ ?>

                <!-- <?php var_dump($mainReport);?> -->

                <h2 class="reportTitle">Übersicht Nr. <?php echo $mainReport->id?></h2>

                <div class="status-btns" style="float: right;margin-right: 10px;">
                    <form class="submit-state"  method="post">
                    <input type="hidden" name="id" value="<?php echo $mainReport->id?>"/>
                    <input type="hidden" name="status" value="Warten auf Kunde"/>
                    <button class="btn btn-info btn-xs">Warten auf Kunden</button>
                    </form>

                    <form class="submit-state"  method="post">
                    <input type="hidden" name="id" value="<?php echo $mainReport->id?>"/>
                    <input type="hidden" name="status" value="Abgeschlossen"/>
                    <input type="submit" class="btn btn-xs btn-success" value="Abschliessen" />
                    </form>
                </div>

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

                <div <?php echo $event->type == "email" ?  "class='event border border-round blue-background'":"class='event border border-round'";  ?>>
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
