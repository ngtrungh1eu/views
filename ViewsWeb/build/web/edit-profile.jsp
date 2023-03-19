
<%-- 
    Document   : edit-profile
    Created on : Mar 15, 2023, 10:11:21 PM
    Author     : khong
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
    <head>
        <meta charset="UTF-8">
        <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge"><![endif]-->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="images/favicon.png" rel="shortcut icon">
        <title>VieWS - VieWatchStore, Luxury</title>

        <!--====== Google Font ======-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800" rel="stylesheet">

        <!--====== Vendor Css ======-->
        <link rel="stylesheet" href="css/vendor.css">

        <!--====== Utility-Spacing ======-->
        <link rel="stylesheet" href="css/utility.css">

        <!--====== App ======-->
        <link rel="stylesheet" href="css/app.css">
    </head>
    <body class="config">
        <div class="preloader is-active">
            <div class="preloader__wrap">

                <img class="preloader__img" src="images/preloader.png" alt=""></div>
        </div>

        <!--====== Main App ======-->
        <div id="app">

            <!--====== Main Header ======-->
            <jsp:include page="header.jsp" ></jsp:include>
            <!--====== End - Main Header ======-->


            <!--====== App Content ======-->
            <div class="app-content">

                <!--====== Section 1 ======-->
                <div class="u-s-p-y-60">

                    <!--====== Section Content ======-->
                    <div class="section__content">
                        <div class="container">
                            <div class="breadcrumb">
                                <div class="breadcrumb__wrap">
                                    <ul class="breadcrumb__list">
                                        <li class="has-separator">

                                            <a href="home">Home</a></li>
                                        <li class="is-marked">

                                            <a href="account">My Account</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section 1 ======-->


                <!--====== Section 2 ======-->
                <div class="u-s-p-b-60">

                    <!--====== Section Content ======-->
                    <div class="section__content">
                        <div class="dash">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-3 col-md-12">

                                        <!--====== Dashboard Features ======-->
                                        <div class="dash__box dash__box--bg-white dash__box--shadow u-s-m-b-30">
                                            <div class="dash__pad-1">

                                                <span class="dash__text u-s-m-b-16">Hello, John Doe</span>
                                                <ul class="dash__f-list">
                                                    <li>

                                                        <a class="dash-active" href="account">Manage My Account</a></li>
                                                    <li>

                                                        <a href="#">My Profile</a></li>
                                                    
                                                </ul>
                                            </div>
                                        </div>
<!--                                        <div class="dash__box dash__box--bg-white dash__box--shadow dash__box--w">
                                            <div class="dash__pad-1">
                                                <ul class="dash__w-list">
                                                    <li>
                                                        <div class="dash__w-wrap">

                                                            <span class="dash__w-icon dash__w-icon-style-1"><i class="fas fa-cart-arrow-down"></i></span>

                                                            <span class="dash__w-text">4</span>

                                                            <span class="dash__w-name">Orders Placed</span></div>
                                                    </li>
                                                    <li>
                                                        <div class="dash__w-wrap">

                                                            <span class="dash__w-icon dash__w-icon-style-2"><i class="fas fa-times"></i></span>

                                                            <span class="dash__w-text">0</span>

                                                            <span class="dash__w-name">Cancel Orders</span></div>
                                                    </li>
                                                    <li>
                                                        <div class="dash__w-wrap">

                                                            <span class="dash__w-icon dash__w-icon-style-3"><i class="far fa-heart"></i></span>

                                                            <span class="dash__w-text">0</span>

                                                            <span class="dash__w-name">Wishlist</span></div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>-->
                                        <!--====== End - Dashboard Features ======-->
                                    </div>
                                    <!-- Toan code -->
                                    <div class="col-lg-9 col-md-12">
                                        <div class="dash__box dash__box--shadow dash__box--radius dash__box--bg-white">
                                            <div class="dash__pad-2">
                                                <h1 class="dash__h1 u-s-m-b-14">Edit Profile</h1>

                                                <span class="dash__text u-s-m-b-30">Looks like you haven't update your profile</span>
                                                <div class="dash__link dash__link--secondary u-s-m-b-30">

                                                    <a data-modal="modal" data-modal-id="#dash-newsletter">Subscribe Newsletter</a></div>
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <form class="dash-edit-p" action = "ProfileAccount" method="GET">
                                                            <div class="gl-inline">
                                                                <div class="u-s-m-b-30">

                                                                    <label class="gl-label" for="reg-fname">FIRST NAME *</label>


                                                                    <input class="input-text input-text--primary-style" type="text" id="reg-fname" name="txtFirstname"></div>
                                                                <div class="u-s-m-b-30">

                                                                    <label class="gl-label" for="reg-lname">LAST NAME *</label>

                                                                    <input class="input-text input-text--primary-style" type="text" id="reg-lname"  name="txtLastname"></div>
                                                            </div>
                                                            <div class="gl-inline">
                                                                <div class="u-s-m-b-30">

                                                                    <!--====== Date of Birth Select-Box ======-->

                                                                    <span class="gl-label">BIRTHDAY</span>
                                                                    <div class="gl-dob"><select class="select-box select-box--primary-style" selected name="txtMonth" type="text">
                                                                            <option >Month</option>
                                                                            <option value="1">January</option>
                                                                            <option value="2">February</option>
                                                                            <option value="3">March</option>
                                                                            <option value="4">April</option>
                                                                            <option value="5">May</option>
                                                                            <option value="6">June</option>
                                                                            <option value="7">July</option>
                                                                            <option value="8">August</option>
                                                                            <option value="9">Septemper</option>
                                                                            <option value="10">October</option>
                                                                            <option value="11">November</option>
                                                                            <option value="12">December</option>

                                                                        </select><select class="select-box select-box--primary-style" name="txtDay" type="text">
                                                                            <option selected>Day</option>
                                                                            <option value="01">01</option>
                                                                            <option value="02">02</option>
                                                                            <option value="03">03</option>
                                                                            <option value="04">04</option>
                                                                            <option value="05">05</option>
                                                                            <option value="06">06</option>
                                                                            <option value="07">07</option>
                                                                            <option value="08">08</option>
                                                                            <option value="09">09</option>
                                                                            <option value="10">10</option>
                                                                            <option value="11">11</option>
                                                                            <option value="12">12</option>
                                                                            <option value="13">13</option>
                                                                            <option value="14">14</option>
                                                                            <option value="15">15</option>
                                                                            <option value="16">16</option>
                                                                            <option value="17">17</option>
                                                                            <option value="18">18</option>
                                                                            <option value="19">19</option>
                                                                            <option value="20">20</option>
                                                                            <option value="21">21</option>
                                                                            <option value="22">22</option>
                                                                            <option value="23">23</option>
                                                                            <option value="24">24</option>
                                                                            <option value="25">25</option>
                                                                            <option value="26">26</option>
                                                                            <option value="27">27</option>
                                                                            <option value="28">28</option>
                                                                            <option value="29">29</option>
                                                                            <option value="30">30</option>
                                                                            <option value="31">31</option>


                                                                        </select><select class="select-box select-box--primary-style" name="txtYear" type="text">
                                                                            <option selected>Year</option>
                                                                            <option value="1991">1991</option>
                                                                            <option value="1992">1992</option>
                                                                            <option value="1993">1993</option>
                                                                            <option value="1994">1994</option>
                                                                            <option value="1995">1995</option>
                                                                            <option value="1996">1996</option>
                                                                            <option value="1997">1997</option>
                                                                            <option value="1998">1998</option>
                                                                            <option value="1999">1999</option>
                                                                            <option value="2000">2000</option>
                                                                            <option value="2001">2001</option>
                                                                            <option value="2002">2002</option>
                                                                        </select></div>
                                                                    <!--====== End - Date of Birth Select-Box ======-->
                                                                </div>
                                                                <div class="u-s-m-b-30">

                                                                    <label class="gl-label" for="gender">GENDER</label><select class="select-box select-box--primary-style u-w-100" id="gender" name="gender">
                                                                        <option selected>Select</option>
                                                                        <option value="Male">Male</option>
                                                                        <option value="Female">Female</option>
                                                                    </select></div>
                                                            </div>
                                                            <div class="u-s-m-b-30">

                                                                <label class="gl-label" for="reg-fname">City *</label>


                                                                <input class="input-text input-text--primary-style" type="text" id="reg-fname" name="txtCity"></div>
                                                            <div class="u-s-m-b-30">

                                                                <label class="gl-label" for="reg-fname">Country *</label>


                                                                <input class="input-text input-text--primary-style" type="text" id="reg-fname" name="txtCountry"></div>
                                                            <div class="gl-inline">
                                                                <!--                                                            <div class="u-s-m-b-30">
                                                                                                                                <h2 class="dash__h2 u-s-m-b-8">E-mail</h2>
                                                                
                                                                                                                                <span class="dash__text">johndoe@domain.com</span>
                                                                                                                                <div class="dash__link dash__link--secondary">
                                                                
                                                                                                                                    <a href="#">Change</a></div>
                                                                                                                            </div>-->
                                                                <!--                                                            <div class="u-s-m-b-30">
                                                                                                                                <h2 class="dash__h2 u-s-m-b-8">Phone</h2>
                                                                
                                                                                                                                <span class="dash__text">Please enter your mobile</span>
                                                                                                                                <div class="dash__link dash__link--secondary">
                                                                
                                                                                                                                    <a href="#">Add</a></div>
                                                                                                                            </div>-->
                                                                <div class="u-s-m-b-30">

                                                                    <label class="gl-label" for="reg-lname">Phone *</label>

                                                                    <input class="input-text input-text--primary-style" type="text" id="reg-lname" name="txtPhone"></div>
                                                            </div>

                                                            <button class="btn btn--e-brand-b-2" type="submit" name="btAction" value="save">SAVE</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Toan code -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--====== End - Section Content ======-->
                </div>
                <!--====== End - Section 2 ======-->
            </div>

            <!--====== Main Footer ======-->

            <jsp:include page="footer.jsp"></jsp:include>

            <!--====== Modal Section ======-->


            <!--====== Unsubscribe or Subscribe Newsletter ======-->
            <div class="modal fade" id="dash-newsletter">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content modal--shadow">
                        <div class="modal-body">
                            <form class="d-modal__form">
                                <div class="u-s-m-b-15">
                                    <h1 class="gl-modal-h1">Newsletter Subscription</h1>

                                    <span class="gl-modal-text">I have read and understood</span>

                                    <a class="d_modal__link" href="dash-edit-profile.html">Ludus Privacy Policy</a>
                                </div>
                                <div class="gl-modal-btn-group">

                                    <button class="btn btn--e-brand-b-2" type="submit">SUBSCRIBE</button>

                                    <button class="btn btn--e-grey-b-2" type="button" data-dismiss="modal">CANCEL</button></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!--====== Unsubscribe or Subscribe Newsletter ======-->
            <!--====== End - Modal Section ======-->
        </div>
        <!--====== End - Main App ======-->


        <!--====== Google Analytics: change UA-XXXXX-Y to be your site's ID ======-->
        <script>
            window.ga = function () {
                ga.q.push(arguments)
            };
            ga.q = [];
            ga.l = +new Date;
            ga('create', 'UA-XXXXX-Y', 'auto');
            ga('send', 'pageview')
        </script>
        <script src="https://www.google-analytics.com/analytics.js" async defer></script>

        <!--====== Vendor Js ======-->
        <script src="js/vendor.js"></script>

        <!--====== jQuery Shopnav plugin ======-->
        <script src="js/jquery.shopnav.js"></script>

        <!--====== App ======-->
        <script src="js/app.js"></script>

        <!--====== Noscript ======-->
        <noscript>
        <div class="app-setting">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="app-setting__wrap">
                            <h1 class="app-setting__h1">JavaScript is disabled in your browser.</h1>

                            <span class="app-setting__text">Please enable JavaScript in your browser or upgrade to a JavaScript-capable browser.</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </noscript>
    </body>
</html>

