<%-- 
    Document   : editproduct
    Created on : Mar 13, 2023, 11:49:03 AM
    Author     : khong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <form class="form-horizontal" action="product">
            <fieldset>

                <!-- Form Name -->
                <legend>PRODUCTS</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_id">PRODUCT ID</label>  
                    <div class="col-md-4">
                        <input id="product_id" name="product_id" value="${requestScope.pDetails.product_id}" placeholder="PRODUCT ID" class="form-control input-md" required="" type="text">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>  
                    <div class="col-md-4">
                        <input id="product_name" name="product_name" value="${pDetails.product_name}" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_name_fr">PRICE</label>  
                    <div class="col-md-4">
                        <input id="product_name_fr" name="price" value="${pDetails.price}" placeholder="PRICE" class="form-control input-md" required="" type="text">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="available_quantity">IMAGE URL</label>  
                    <div class="col-md-4">
                        <input id="available_quantity" name="image" value="${pDetails.image}" placeholder="IMAGE URL" class="form-control input-md" required="" type="text">

                    </div>
                </div>

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_categorie">PRODUCT CATEGORY</label>
                    <div class="col-md-4">
                        <select id="product_categorie" name="product_categorie" class="form-control">
                            <option value="1">Curnon</option>
                            <option value="2">Klasern</option>
                            <option value="3">Eternowatch</option>
                            <option value="4">VIWAT</option>
                            <option value="5">Yors</option>
                            <option value="6">Other</option>

                        </select>
                    </div>
                </div>

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_categorie">GENDER</label>
                    <div class="col-md-4">
                        <select id="product_categorie" name="type" class="form-control">
                            <option value="Men">Men</option>
                            <option value="Women">Women</option>


                        </select>
                    </div>
                </div>


                <!-- Text input-->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="product_weight">PRODUCT WEIGHT</label>  
                                    <div class="col-md-4">
                                        <input id="product_weight" name="product_weight" placeholder="PRODUCT WEIGHT" class="form-control input-md" required="" type="text">
                
                                    </div>
                                </div>-->

                <!-- Textarea -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_description">PRODUCT DESCRIPTION</label>
                    <div class="col-md-4">                     
                        <textarea class="form-control" id="product_description" name="product_description"></textarea>
                    </div>
                </div>

                <!-- Textarea -->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="product_name_fr">PRODUCT DESCRIPTION FR</label>
                                    <div class="col-md-4">                     
                                        <textarea class="form-control" id="product_name_fr" name="product_name_fr"></textarea>
                                    </div>
                                </div>-->

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="percentage_discount">PERCENTAGE DISCOUNT</label>  
                    <div class="col-md-4">
                        <input id="percentage_discount" name="saleoff" value="${requestScope.pDetails.saleoff}" placeholder="PERCENTAGE DISCOUNT" class="form-control input-md" required="" type="text">

                    </div>
                </div>

                <!-- Text input-->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="stock_alert">STOCK ALERT</label>  
                                    <div class="col-md-4">
                                        <input id="stock_alert" name="stock_alert" placeholder="STOCK ALERT" class="form-control input-md" required="" type="text">
                
                                    </div>
                                </div>-->

                <!-- Search input-->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="stock_critical">STOCK CRITICAL</label>
                                    <div class="col-md-4">
                                        <input id="stock_critical" name="stock_critical" placeholder="STOCK CRITICAL" class="form-control input-md" required="" type="search">
                                    </div>
                                </div>-->
                <!-- Search input-->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="tutorial">TUTORIAL</label>
                                    <div class="col-md-4">
                                        <input id="tutorial" name="tutorial" placeholder="TUTORIAL" class="form-control input-md" required="" type="search">
                
                                    </div>
                                </div>-->

                <!-- Search input-->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="tutorial_fr">TUTORIAL FR</label>
                                    <div class="col-md-4">
                                        <input id="tutorial_fr" name="tutorial_fr" placeholder="TUTORIAL FR" class="form-control input-md" required="" type="search">
                
                                    </div>
                                </div>-->

                <!-- Text input-->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="online_date">ONLINE DATE</label>  
                                    <div class="col-md-4">
                                        <input id="online_date" name="online_date" placeholder="ONLINE DATE" class="form-control input-md" required="" type="text">
                
                                    </div>
                                </div>-->
                <!-- Text input-->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="author">AUTHOR</label>  
                                    <div class="col-md-4">
                                        <input id="author" name="author" placeholder="AUTHOR" class="form-control input-md" required="" type="text">
                
                                    </div>
                                </div>-->

                <!-- Text input-->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="enable_display">ENABLE DISPLAY</label>  
                                    <div class="col-md-4">
                                        <input id="enable_display" name="enable_display" placeholder="ENABLE DISPLAY" class="form-control input-md" required="" type="text">
                
                                    </div>
                                </div>-->

                <!-- Text input-->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="comment">COMMENT</label>  
                                    <div class="col-md-4">
                                        <input id="comment" name="comment" placeholder="COMMENT" class="form-control input-md" required="" type="text">
                
                                    </div>
                                </div>-->

                <!-- Text input-->
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="approuved_by">APPROUVED BY</label>  
                                    <div class="col-md-4">
                                        <input id="approuved_by" name="approuved_by" placeholder="APPROUVED BY" class="form-control input-md" required="" type="text">-->

                <!-- File Button --> 
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="filebutton">main_image</label>
                                    <div class="col-md-4">
                                        <input id="filebutton" name="filebutton" class="input-file" type="file">
                                    </div>
                                </div>-->
                <!-- File Button --> 
                <!--                <div class="form-group">
                                    <label class="col-md-4 control-label" for="filebutton">auxiliary_images</label>
                                    <div class="col-md-4">
                                        <input id="filebutton" name="filebutton" class="input-file" type="file">
                                    </div>
                                </div>-->

                <!-- Button -->
                <div class="form-group">               
                    <label class="col-md-4 control-label" for="singlebutton">Single Button</label>
                    <div class="col-md-4">
                        <button id="singlebutton" name="action" value="${requestScope.action}" class="btn btn-primary">Button</button>
                        <!--<button id="singlebutton" name="action" value="insert" class="btn btn-primary">Button</button>-->

                    </div>
                </div>

            </fieldset>
        </form>
    </body>
</html>
