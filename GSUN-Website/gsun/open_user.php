<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>GSUN Web Client</title>
        <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript"></script>

        <script type="text/javascript" src="http://jzaefferer.github.com/jquery-validation/jquery.validate.js"></script>


        <style type="text/css">
            .heading {
                font-family: Arial, Helvetica, sans-serif;
                background-color: #99C;
                height: 10%;
                width: 100%;
                text-align: center;
                font-size: x-large;
            }
            .item_catagory {
                height: 50%;
                width: 50%;
                float: left;
            }
            .type_catagory_form {
                height: 100%;
                width: 100%;
                float: left;
            }
            .content {
                font-family: Arial, Helvetica, sans-serif;

                float: left;
                height: 70%;
                width: 60%;
            }
            .map {
                font-family: Arial, Helvetica, sans-serif;

                float: left;
                height: 70%;
                width: 40%;
            }
            .basic_heading {
                font-family: Arial, Helvetica, sans-serif;
                font-size: 16px;
                background-color: #E5ECF9;
                float: left;
                height: 10%;
                width: 98%;
                padding-left: 3px;
            }
            .google_map {
                padding: 3%;
                float: left;
                height: 220px;
                width: 92%;
                font-family: Arial, Helvetica, sans-serif;
            }
            .map_details {
                padding: 3%;
                float: left;
                height: 40%;
                width: 92%;
                font-family: Arial, Helvetica, sans-serif;
            }
            .longitude_label {
                font-family: Arial, Helvetica, sans-serif;
                font-size: 14px;
                background-color: #E5ECF9;
                float: left;
                width: 40%;
                margin-top: 10px;
                font-weight: bold;
                padding-left: 3px;
            }
            .shop_discription {
                font-family: Arial, Helvetica, sans-serif;
                font-size: 16px;
                float: left;
                height: 10%;
                width: 100%;
                margin-left: 5%;
                margin-bottom: 2%;
            }
            .Items {
                float: left;
                height: 10%;
                width: 37%;
                padding-left: 5%;
            }
            .item_name {
                width: 43%;
                padding-bottom: 0%;
                padding-left: 2%;
                height: 26px;
                float: left;
            }
            .map_heading {
                font-family: Arial, Helvetica, sans-serif;
                font-size: 16px;
                background-color: #E5ECF9;
                float: left;
                height: 10%;
                width: 98%;
                padding-left: 3px;
            }
            .free {
                height: 10%;
                width: 100%;
            }
            .container {
                float: left;
                height: 100%;
                width: 100%;
            }
            .fixed_output_lonLag {
                float: left;
                margin-top: 10px;
                width: 50%;
            }
            .form_item {
                font-family: Arial, Helvetica, sans-serif;
                width: 40%;
                padding-left: 20px;
                float: left;
                margin-top: 5px;
            }
            .form_item_input {
                font-family: Arial, Helvetica, sans-serif;
                float: left;
                width: 50%;
                margin-top: 5px;
            }
            .reset_button {
                margin-left: 60%;
                margin-top: 5px;
            }
            .free2 {
                float: left;
                height: 20px;
                width: 40%;
            }
            .shop_details {
                float: left;
                height: 10%;
                width: 100%;
                margin-top: 5%;
            }
            .submit_button {
                background-color: #6F9;
                float: left;
                height: 20%;
                width: 35%;
                padding-left: 40%;
                margin-top: 2%;
            }
            .advertisement {
                float: left;
                width: 50%;
            }
            .error {
                font-family: Arial, Helvetica, sans-serif;
                font-size: 16px;
                font-weight: bold;
                color: #FFF;
                text-decoration: blink;
                background-color: #F00;
                float: left;
                height: 10%;
                width: 50%;
                padding-left: 5%;
            }
        </style>

        <script type="text/javascript">
            $(document).ready(function(){
                $("#shop_form").validate();
            });
        </script>

    </head>

    <body>
        <div class="container">
            <div class="heading"> <strong>GSUN - Web Client</strong></div>
            <br/><br/>



            <div class="content">

                <div class="basic_heading"><strong>Basic Information</strong></div>
                <br/><br/>
                <!--  form_submit.php onsubmit="form_validate()-->
                <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post" name="shop_form" id="shop_form">
                    <div class="form_item">Shop Name</div>
                    <div class="form_item_input"><input name="shop_name" id="shop_name" type="text" class="required"/></div>
                    <br/>

                    <div class="form_item">Shop Address</div>
                    <div class="form_item_input">
                        <textarea name="shop_address" id="shop_address" rows="5" class="required"></textarea>
                    </div>
                    <br/>

                    <div class="form_item">Telephone No.</div>
                    <div class="form_item_input"><input name="shop_telephone" id="shop_telephone" type="text" class="required"/> e.g.: +94781234567</div>
                    <br/>

                    <div class="form_item">Email</div>
                    <div class="form_item_input"><input name="shop_email" type="text" class="required email"/></div>
                    <br/>

                    <div class="form_item">Description<br/></div>
                    <div class="form_item_input"> <textarea name="shop_description" rows="10"></textarea></div>
                    <br/>


                    <!--  </form>-->

            </div>



            <div class="map">
                <div class="map_heading"><strong> Map</strong></div>
                <br/>
                Select The Place From Map<br/>
                <div class="google_map" id="google_map"><script  src="googlemapscript.js"></script> </div>

                <br/><br/>
                <div class="map_details">

                    <div class="longitude_label">Longitude</div>
                    <div class="fixed_output_lonLag"><input name="shop_longitude" type="text" id="longitude" maxlength="20" readonly="readonly" class="required" /></div>
                    <br/>

                    <div class="longitude_label">Latitude</div>
                    <div class="fixed_output_lonLag"><input name="shop_latitude" type="text" id="latitude" maxlength="20" readonly="readonly" class="required" /></div>
                    <br/>
                    <div class="reset_button"></div>
                    <div class="reset_button"><input name="reset_button" type="button" id="reset_button" onClick="clearMarkers()" value="Clear Marker" /></div>
                </div>
            </div>

            <div class="error" id="error"></div>


            <div class="shop_details">
                <div class="basic_heading"><strong>Shop Information</strong></div>
                <br/><br/>
                <div class="shop_discription">Name Top Five Things In Shop With Catagory</div>

                <div class="item_catagory">

                    <div class="Items">  <h4>Item</h4>  </div>
                    <div class="Items">  <h4>Catagory</h4>  </div>
                    <div class="type_catagory_form">

                        <!--  <form name="form" id="form_type_catagory">-->

                        <div class="item_name">   <input name="item1" type="text" id="item1" class="required" />    </div>

                        <div class="item_name">  
                            <select name="select_menu_1" id="select_menu_1"><?php writeMenuItems(); ?></select>
                        </div>



                        <div class="item_name">  <input name="item2" type="text" />    </div>

                        <div class="item_name">
                            <select name="select_menu_2" id="select_menu_2"><?php writeMenuItems(); ?></select>
                        </div>

                        <div class="item_name">     <input name="item3" type="text" />    </div>

                        <div class="item_name">

                            <select name="select_menu_3" id="select_menu_3"><?php writeMenuItems(); ?></select>
                        </div>
                        <div class="item_name">  <input name="item4" type="text" />  </div>

                        <div class="item_name">

                            <select name="select_menu_4" id="select_menu_4"><?php writeMenuItems(); ?></select>
                        </div>

                        <div class="item_name">   <input name="item5" type="text" />   </div>

                        <div class="item_name">

                            <select name="select_menu_5" id="select_menu_5"><?php writeMenuItems(); ?></select>
                        </div>


                        <?php

                        function writeMenuItems() {
                            echo "<option>Computer</option>
          <option>Stationary</option>
          <option>Bakary Product</option>
          <option>Food</option>
          <option>Medicine</option>
          <option>Clothing</option>
          <option>Electronic Equipments</option>
          <option>Vehicles and Services</option>";
                        }
                        ?>


                        <br/><br/>
                        <div class="submit_button"> <input name="submit_button" type="submit" id="submit_button"  value="Submit Details" /></div>
                        </form>
                    </div>

                    <br/>



                </div>


                <div class="advertisement">Ad Here:</div><br/> 






            </div>
          


            <?php
//If the form is submitted
            if (isset($_POST['submit_button'])) {


                //Check to make sure that the name field is not empty
                if (trim($_POST['shop_name']) == '') {
                    $hasError = true;
                } else {
                    $shop_name = trim($_POST['shop_name']);
                }

                //Check to make sure that the subject field is not empty
                if (trim($_POST['shop_address']) == '') {
                    $hasError = true;
                } else {
                    $shop_address = trim($_POST['shop_address']);
                }

                if (trim($_POST['shop_telephone']) == '') {
                    $hasError = true;
                } else {
                    $shop_telephone = trim($_POST['shop_telephone']);
                }

                //Check to make sure sure that a valid email address is submitted
                if (trim($_POST['shop_email']) == '') {
                    $hasError = true;
                } else if (!filter_var($_POST['shop_email'], FILTER_VALIDATE_EMAIL)) {
                    $hasError = true;
                } else {
                    $shop_email = trim($_POST['shop_email']);
                }

                if (!isset($hasError)) {

                    $need_type = '';
                    $shop_description = trim($_POST['shop_description']);

                    $shop_longitude = trim($_POST['shop_longitude']); // id=longitude
                    $shop_latitude = trim($_POST['shop_latitude']); // id=latitude

                    for ($i = 1; $i < 6; $i++) {
                        if (trim($_POST["item" . $i]) == '') {
                            
                        } else {
                            $need_type.=trim($_POST["item" . $i]) . "," . trim($_POST["select_menu_" . $i]) . ":";
                        }
                    }



                    //// send to database
                   
                    $db = new mysqli('localhost', 'root', '', 'gsun_temp_db');

                    if (!$db) {

                        echo 'Could not connect to the database.';
                    } else {
                        $stmt=$db->prepare("INSERT INTO shops VALUES (?,?,?,?,?,?,?,?)");
                        
                        $stmt->bind_param('ssssssss', $shop_name,$shop_longitude,$shop_latitude,$shop_address,$shop_telephone,$shop_email,$shop_description,$need_type);
                        
                        $stmt->execute();
                        
                        $stmt->close();
                        
                        ?> 
            <div class="submit_button" id="submit_meaasge"><strong>Details of the shop successfully submitted!</strong></div>
                            <?php
                    }
                }
            }
            ?>



    </body>
</html>
