<%-- 
    Document   : account
    Created on : Feb 26, 2023, 2:38:31 PM
    Author     : ROG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <jsp:include page="header.jsp"></jsp:include>
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

                                                <a href="index.html">Home</a></li>
                                            <li class="is-marked">

                                                <a href="dashboard.html">My Account</a></li>
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

                                                    <span class="dash__text u-s-m-b-16">Hello, ${sessionScope.Account.last_name} </span>
                                                <ul class="dash__f-list">
                                                    <li>

                                                        <a class="dash-active" href="dashboard.html">Manage My Account</a></li>
                                                    <li>

                                                        <a href="edit-profile.jsp">My Profile</a></li>
                                                    <li>

                                                        
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="dash__box dash__box--bg-white dash__box--shadow dash__box--w">
                                            <div class="dash__pad-1">
                                                <ul class="dash__w-list">
                                                    <li>
                                                        <div class="dash__w-wrap">

                                                            <span class="dash__w-icon dash__w-icon-style-1"><i class="fas fa-cart-arrow-down"></i></span>

                                                            <span class="dash__w-text">${Hsize}</span>

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
                                        </div>
                                        <!--====== End - Dashboard Features ======-->
                                    </div>
                                    <div class="col-lg-9 col-md-12">
                                        <div class="dash__box dash__box--shadow dash__box--radius dash__box--bg-white u-s-m-b-30">
                                            <div class="dash__pad-2">
                                                <h1 class="dash__h1 u-s-m-b-14">Manage My Account</h1>

                                                <span class="dash__text u-s-m-b-30">From your My Account Dashboard you have the ability to view a snapshot of your recent account activity and update your account information. Select a link below to view or edit information.</span>
                                                <div class="row">
                                                    <!--                                                    <div class="col-lg-4 u-s-m-b-30">
                                                                                                            <div class="dash__box dash__box--bg-grey dash__box--shadow-2 u-h-100">
                                                                                                                <div class="dash__pad-3">
                                                                                                                    <h2 class="dash__h2 u-s-m-b-8">PERSONAL PROFILE</h2>
                                                                                                                    <div class="dash__link dash__link--secondary u-s-m-b-8">
                                                    
                                                                                                                        <a href="dash-edit-profile.html">Edit</a></div>
                                                    
                                                                                                                    <span class="dash__text">John Doe</span>
                                                    
                                                                                                                    <span class="dash__text">johndoe@domain.com</span>
                                                                                                                    <div class="dash__link dash__link--secondary u-s-m-t-8">
                                                    
                                                                                                                        <a data-modal="modal" data-modal-id="#dash-newsletter">Subscribe Newsletter</a></div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>-->

                                                                   </div>

                                                                <!--                                                                <span class="dash__text">John Doe</span>
                                                                
                                                                                                                                <span class="dash__text">johndoe@domain.com</span>-->
                                                            
                                                            <div class="dash__pad-3">
                                                                <h1 class="dash__h2 u-s-m-b-8">User Profile</h1>
                                                                <table class="dash__text">
                                                                    <tr>
                                                                        <td>First Name:</td>
                                                                        <td>${sessionScope.AccountP.first_name}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Last Name:</td>
                                                                        <td>${sessionScope.AccountP.last_name}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Phone:</td>
                                                                        <td>${sessionScope.AccountP.phone}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Gender:</td>
                                                                        <td>${sessionScope.AccountP.gender}</td>
                                                                    </tr>
                                                                  
                                                                     <tr>
                                                                        <td>Country:</td>
                                                                        <td>${sessionScope.AccountP.country}</td>
                                                                    </tr>
                                                                     <tr>
                                                                        <td>City:</td>
                                                                        <td>${sessionScope.AccountP.city}</td>
                                                                    </tr>
                                                                </table>
                                                                    <a class="dash__h2 u-s-m-b-8" href="edit-profile.jsp">Edit</a>
                                                            </div>
                                                                     
                                                        </div>
                                                    </div>
                                                    <!--                                                    <div class="col-lg-4 u-s-m-b-30">
                                                                                                            <div class="dash__box dash__box--bg-grey dash__box--shadow-2 u-h-100">
                                                                                                                <div class="dash__pad-3">
                                                                                                                    <h2 class="dash__h2 u-s-m-b-8">ADDRESS BOOK</h2>
                                                    
                                                                                                                    <span class="dash__text-2 u-s-m-b-8">Default Shipping Address</span>
                                                                                                                    <div class="dash__link dash__link--secondary u-s-m-b-8">
                                                    
                                                                                                                        <a href="dash-address-book.html"></a></div>
                                                    
                                                                                                                    <span class="dash__text">4247 Ashford Drive Virginia - VA-20006 - USA</span>
                                                    
                                                                                                                    <span class="dash__text">(+0) 900901904</span>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>-->
                                                    <!--                                                    <div class="col-lg-4 u-s-m-b-30">
                                                                                                        </div>
                                                                                                        <div class="col-lg-4 u-s-m-b-30">
                                                                                                            <div class="dash__box dash__box--bg-grey dash__box--shadow-2 u-h-100">
                                                                                                                <div class="dash__pad-3">
                                                                                                                    <h2 class="dash__h2 u-s-m-b-8">BILLING ADDRESS</h2>
                                                    
                                                                                                                    <span class="dash__text-2 u-s-m-b-8">Default Billing Address</span>
                                                    
                                                                                                                    <span class="dash__text">4247 Ashford Drive Virginia - VA-20006 - USA</span>
                                                    
                                                                                                                    <span class="dash__text">(+0) 900901904</span>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>-->
                                                </div>
                                            </div>
                                        </div>
                                        <div class="dash__box dash__box--shadow dash__box--bg-white dash__box--radius">
                                            <h2 class="dash__h2 u-s-p-xy-20">RECENT ORDERS</h2>
                                            <div class="dash__table-wrap gl-scroll">
                                                <table class="dash__table">
                                                    <thead>
                                                        <tr>
                                                            <th>Order #</th>
                                                            <th>Placed On</th>
                                                            <th>Items</th>
                                                            <th>Total</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="dto" items="${requestScope.history}">
                                                        <tr>
                                                            <td>${dto.OID}</td>
                                                            <td>${dto.date}</td>
                                                            <td>
                                                                <div class="dash__table-img-wrap">

                                                                    <img class="u-img-fluid" src="${dto.image}" alt=""></div>
                                                            </td>
                                                            <td>
                                                                <div class="dash__table-total">

                                                                    <span>${dto.total}</span>
                                                                    <div class="dash__link dash__link--brand">

                                                                        <a href="dash-manage-order.html">MANAGE</a></div>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                         </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--====== End - Section Content ======-->
                </div>
                <!--====== End - Section 2 ======-->
            </div>
            <!--====== End - App Content ======-->


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

                                    <a class="d_modal__link" href="dashboard.html">Ludus Privacy Policy</a>
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