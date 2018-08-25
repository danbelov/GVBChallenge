<?php

    $json = file_get_contents("https://7ed86656-f226-49a4-ad3f-9676893cc520.mock.pstmn.io/DamageReport");
    $reports = json_decode($json);
?>
<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>The HTML5 Herald</title>
  <meta name="description" content="The HTML5 Herald">
  <meta name="author" content="SitePoint">

  <link rel="stylesheet" href="css/styles.css?v=1.0">
  <script src="js/scripts.js"></script>

</head>
<body>
    <?php
    foreach($reports as $r){

        ?>
        <aside>
            <p><?php echo $r->name;?></p>
            <p><?php echo $r->status;?></p>
        </aside>

        <main>
        </main>
        <?php
    }
    ?>
</body>
</html>