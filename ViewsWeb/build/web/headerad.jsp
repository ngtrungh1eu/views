<%-- 
    Document   : headerad
    Created on : Mar 17, 2023, 2:51:11 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header class="header-desktop3 d-none d-lg-block" style="background-color: #000">
    <div class="section__content section__content--p35">
        <div class="header3-wrap">
            <div class="header__logo">
                <a href="#">
                    <img src="images\logo\001.png" alt="Logo" width="100px" height="52px" />
                </a>
            </div>
            <div class="header__navbar">

                <ul class="list-unstyled">
                    <li>
                        <a href="DispatchController?btAction=Usermanager" style="color: #ffffff">
                            <i class="fas fa-shopping-basket"></i>
                            <span class="bot-line"></span>User Manager</a>
                    </li>
                    <li>
                        <a href="DispatchController?btAction=ProductManager" style="color: #ffffff">
                            <i class="fas fa-shopping-basket"></i>
                            <span class="bot-line"></span>Product Manager</a>
                    </li>
                    <li>
                        <a href="DispatchController?btAction=OrderManager" style="color: #ffffff">
                            <i class="fas fa-trophy"></i>
                            <span class="bot-line"></span>Order Manager</a>
                    </li>
                </ul>

                <!--                            <ul class="list-unstyled">
                                                <li>
                                                    <a href="DispatchController">
                                                        <i class="fas fa-tachometer-alt" name = "btAction" value = "Usermanager">User Manager</i>
                                                        <span class="bot-line"></span>
                                                    </a>
                                                   
                                                </li>
                                                <li>
                                                    <a href="product">
                                                        <i class="fas fa-shopping-basket"></i>
                                                        <span class="bot-line"></span>Order Manager</a>
                                                </li>
                                                <li>
                                                    <a href="table.html">
                                                        <i class="fas fa-trophy"></i>
                                                        <span class="bot-line"></span>Features</a>
                                                </li>
                                                <li class="has-sub">
                                                    <a href="#">
                                                        <i class="fas fa-copy"></i>
                                                        <span class="bot-line"></span>Pages</a>
                                                    <ul class="header3-sub-list list-unstyled">
                                                        <li>
                                                            <a href="login.html">Login</a>
                                                        </li>
                                                        <li>
                                                            <a href="register.html">Register</a>
                                                        </li>
                                                        <li>
                                                            <a href="forget-pass.html">Forget Password</a>
                                                        </li>
                                                    </ul>
                                                </li>
                                                <li class="has-sub">
                                                    <a href="#">
                                                        <i class="fas fa-desktop"></i>
                                                        <span class="bot-line"></span>UI Elements</a>
                                                    <ul class="header3-sub-list list-unstyled">
                                                        <li>
                                                            <a href="button.html">Button</a>
                                                        </li>
                                                        <li>
                                                            <a href="badge.html">Badges</a>
                                                        </li>
                                                        <li>
                                                            <a href="tab.html">Tabs</a>
                                                        </li>
                                                        <li>
                                                            <a href="card.html">Cards</a>
                                                        </li>
                                                        <li>
                                                            <a href="alert.html">Alerts</a>
                                                        </li>
                                                        <li>
                                                            <a href="progress-bar.html">Progress Bars</a>
                                                        </li>
                                                        <li>
                                                            <a href="modal.html">Modals</a>
                                                        </li>
                                                        <li>
                                                            <a href="switch.html">Switchs</a>
                                                        </li>
                                                        <li>
                                                            <a href="grid.html">Grids</a>
                                                        </li>
                                                        <li>
                                                            <a href="fontawesome.html">FontAwesome</a>
                                                        </li>
                                                        <li>
                                                            <a href="typo.html">Typography</a>
                                                        </li>
                                                    </ul>
                                                </li>
                                            </ul>-->
            </div>
   
                <div class="account-wrap">
                    <div class="account-item account-item--style2 clearfix js-item-menu">
                        <div class="image">
                            <img src="images/icon/admin.png" alt="John Doe" />
                        </div>
                        <div class="content">
                            <a class="js-acc-btn" href="#">${Account.last_name}</a>
                        </div>
                        <div class="account-dropdown js-dropdown">
                            <div class="info clearfix">
                                <div class="image">
                                    <a href="#">
                                        <img src="images/icon/admin.png" alt=${Account.last_name} />
                                    </a>
                                </div>
                                <div class="content">
                                    <h5 class="name">
                                        <a href="#">${Account.last_name}</a>
                                    </h5>
                                    <span class="email"></span>
                                </div>
                            </div>
                         
                            <div class="account-dropdown__footer">
                                <a href="signout">
                                    <i class="zmdi zmdi-power"></i>Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>