<%-- 
    Document   : cart
    Created on : Feb 26, 2023, 2:48:49 PM
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

                                                <a href="cart.html">Cart</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--====== End - Section 1 ======-->


                    <!--====== Section 2 ======-->
                    <div class="u-s-p-b-60">

                        <!--====== Section Intro ======-->
                        <div class="section__intro u-s-m-b-60">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="section__text-wrap">
                                            <h1 class="section__heading u-c-secondary">SHOPPING CART</h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--====== End - Section Intro ======-->


                        <!--====== Section Content ======-->
                        <div class="section__content">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 u-s-m-b-30">
                                        <div class="table-responsive">
                                            <table class="table-p">
                                                <tbody>

                                                    <!--====== Row ======-->
                                                <c:set var="userID" value="${sessionScope.Account.user_id}"></c:set>
                                                <c:set var="o" value="${requestScope.cart}"></c:set>
                                                <c:forEach items="${o.items}" var="i">
                                                    <c:set var="user_id" value="${i.user_id}"></c:set>
                                                    <c:if test="${userID == user_id}">
                                                        <tr>
                                                            <td>
                                                            <div class="table-p__box">
                                                                <div class="table-p__img-wrap">

                                                                    <img class="u-img-fluid" src="${i.product.image}" alt=""></div>
                                                                <div class="table-p__info">

                                                                    <span class="table-p__name">

                                                                        <a href="product-detail.html">${i.product.product_name}</a></span>

                                                                    <span class="table-p__category">

                                                                        <a href="shop-side-version-2.html">${i.product.brand}</a></span>
                                                                    <ul class="table-p__variant-list">
                                                                        <li>

                                                                            <span>Size: 22</span></li>
                                                                        <li>

                                                                            <span>Price: $${i.product.newPrice}</span></li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td>

                                                            <span class="table-p__price">$${(i.price*i.quantity)}</span></td>
                                                        <td>
                                                            <div class="table-p__input-counter-wrap">

                                                                <!--====== Input Counter ======-->
                                                                <div class="input-counter">

                                                                        <a href="process?quantity=-1&id=${i.product.product_id}&user_id=${i.user_id}" class="input-counter__minus fas fa-minus" ></a> 

                                                                    <input class="input-counter__text input-counter--text-primary-style" type="text" value="${i.quantity}" data-min="1" data-max="1000">
                                                                    
                                                                    <a href="process?quantity=1&id=${i.product.product_id}&user_id=${i.user_id}" class="input-counter__plus fas fa-plus" ></a>
                                                                    <!--<span class="input-counter__plus fas fa-plus"></span>--> 
                   
                                                                
                                                                </div>
                                                                <!--====== End - Input Counter ======-->
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="table-p__del-wrap">

                                                                <a class="far fa-trash-alt table-p__delete-link" href="process?id=${i.product.product_id}&user_id=${i.user_id}&quantity=0"></a></div>
                                                        </td>
                                                    </tr>
                                                    </c:if>
                                                    </c:forEach>
                                                    <!--====== End - Row ======-->


                                                    <!--====== Row ======-->
<!--                                                    <tr>
                                                        <td>
                                                            <div class="table-p__box">
                                                                <div class="table-p__img-wrap">

                                                                    <img class="u-img-fluid" src="images/product/women/product8.jpg" alt=""></div>
                                                                <div class="table-p__info">

                                                                    <span class="table-p__name">

                                                                        <a href="product-detail.html">New Dress D Nice Elegant</a></span>

                                                                    <span class="table-p__category">

                                                                        <a href="shop-side-version-2.html">Women Clothing</a></span>
                                                                    <ul class="table-p__variant-list">
                                                                        <li>

                                                                            <span>Size: 22</span></li>
                                                                        <li>

                                                                            <span>Color: Red</span></li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td>

                                                            <span class="table-p__price">$125.00</span></td>
                                                        <td>
                                                            <div class="table-p__input-counter-wrap">

                                                                ====== Input Counter ======
                                                                <div class="input-counter">

                                                                    <span class="input-counter__minus fas fa-minus"></span>

                                                                    <input class="input-counter__text input-counter--text-primary-style" type="text" value="1" data-min="1" data-max="1000">

                                                                    <span class="input-counter__plus fas fa-plus"></span></div>
                                                                ====== End - Input Counter ======
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="table-p__del-wrap">

                                                                <a class="far fa-trash-alt table-p__delete-link" href="#"></a></div>
                                                        </td>
                                                    </tr>
                                                    ====== End - Row ======


                                                    ====== Row ======
                                                    <tr>
                                                        <td>
                                                            <div class="table-p__box">
                                                                <div class="table-p__img-wrap">

                                                                    <img class="u-img-fluid" src="images/product/men/product8.jpg" alt=""></div>
                                                                <div class="table-p__info">

                                                                    <span class="table-p__name">

                                                                        <a href="product-detail.html">New Fashion D Nice Elegant</a></span>

                                                                    <span class="table-p__category">

                                                                        <a href="shop-side-version-2.html">Men Clothing</a></span>
                                                                    <ul class="table-p__variant-list">
                                                                        <li>

                                                                            <span>Size: 22</span></li>
                                                                        <li>

                                                                            <span>Color: Red</span></li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td>

                                                            <span class="table-p__price">$125.00</span></td>
                                                        <td>
                                                            <div class="table-p__input-counter-wrap">

                                                                ====== Input Counter ======
                                                                <div class="input-counter">

                                                                    <span class="input-counter__minus fas fa-minus"></span>

                                                                    <input class="input-counter__text input-counter--text-primary-style" type="text" value="1" data-min="1" data-max="1000">

                                                                    <span class="input-counter__plus fas fa-plus"></span></div>
                                                                ====== End - Input Counter ======
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="table-p__del-wrap">

                                                                <a class="far fa-trash-alt table-p__delete-link" href="#"></a></div>
                                                        </td>
                                                    </tr>-->
                                                    <!--====== End - Row ======-->
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="route-box">
                                            <div class="route-box__g1">

                                                <a class="route-box__link" href="home"><i class="fas fa-long-arrow-alt-left"></i>

                                                    <span>CONTINUE SHOPPING</span></a></div>
                                            <div class="route-box__g2">

                                                <a class="route-box__link" href="cart.html"><i class="fas fa-trash"></i>

                                                    <span>CLEAR CART</span></a>

                                                <a class="route-box__link" href="cart.html"><i class="fas fa-sync"></i>

                                                    <span>UPDATE CART</span></a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--====== End - Section Content ======-->
                    </div>
                    <!--====== End - Section 2 ======-->


                    <!--====== Section 3 ======-->
                    <div class="u-s-p-b-60">

                        <!--====== Section Content ======-->
                        <div class="section__content">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 u-s-m-b-30">
                                        <form class="f-cart" action="DispatchController" >
                                            <div class="row">
<!--                                                <div class="col-lg-4 col-md-6 u-s-m-b-30">
                                                    <div class="f-cart__pad-box">
                                                        <h1 class="gl-h1">ESTIMATE SHIPPING AND TAXES</h1>

                                                        <span class="gl-text u-s-m-b-30">Enter your destination to get a shipping estimate.</span>
                                                        <div class="u-s-m-b-30">

                                                            ====== Select Box ======

                                                            <label class="gl-label" for="shipping-country">COUNTRY *</label><select class="select-box select-box--primary-style" id="shipping-country">
                                                                <option selected value="">Choose Country</option>
                                                                <option value="uae">United Arab Emirate (UAE)</option>
                                                                <option value="uk">United Kingdom (UK)</option>
                                                                <option value="us">United States (US)</option>
                                                            </select>
                                                            ====== End - Select Box ======
                                                        </div>
                                                        <div class="u-s-m-b-30">

                                                            ====== Select Box ======

                                                            <label class="gl-label" for="shipping-state">STATE/PROVINCE *</label><select class="select-box select-box--primary-style" id="shipping-state">
                                                                <option selected value="">Choose State/Province</option>
                                                                <option value="al">Alabama</option>
                                                                <option value="al">Alaska</option>
                                                                <option value="ny">New York</option>
                                                            </select>
                                                            ====== End - Select Box ======
                                                        </div>
                                                        <div class="u-s-m-b-30">

                                                            <label class="gl-label" for="shipping-zip">ZIP/POSTAL CODE *</label>

                                                            <input class="input-text input-text--primary-style" type="text" id="shipping-zip" placeholder="Zip/Postal Code"></div>
                                                        <div class="u-s-m-b-30">

                                                            <a class="f-cart__ship-link btn--e-transparent-brand-b-2" href="cart.html">CALCULATE SHIPPING</a></div>

                                                        <span class="gl-text">Note: There are some countries where free shipping is available otherwise our flat rate charges or country delivery charges will be apply.</span>
                                                    </div>
                                                </div>-->
                                                <div class="col-lg-6 col-md-6 u-s-m-b-30">
                                                    <div class="f-cart__pad-box">
                                                        <h1 class="gl-h1">NOTE</h1>

                                                        <span class="gl-text u-s-m-b-30">Add Special Note About Your Product</span>
                                                        <div>

                                                            <label for="f-cart-note"></label><textarea class="text-area text-area--primary-style" id="f-cart-note"></textarea></div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 u-s-m-b-30">
                                            <div class="f-cart__pad-box">
                                                <div class="u-s-m-b-30">
                                                    <table class="f-cart__table">
                                                        <tbody>

                                                        <tr>
                                                            <td>TAX</td>
                                                            <c:set var="tax" value="${o.totalMoney*0.05}" ></c:set>
                                                            <td>$ ${tax}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>SUBTOTAL</td>
                                                            <td>$ ${o.totalMoney}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>GRAND TOTAL</td>
                                                            <td>$ ${o.totalMoney + tax}</td>
                                                        </tr>
                                                    </tbody>
                                                    </table>
                                                </div>
                                                <div>

                                                    <button class="btn btn--e-brand-b-2" type="submit" name="btAction" value="checkout" > PROCEED TO CHECKOUT</button></div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 3 ======-->
        </div>
        <!--====== End - App Content ======-->


        <!--====== Main Footer ======-->
            <jsp:include page="footer.jsp"></jsp:include>
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
