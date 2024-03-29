<%-- 
    Document   : menu
    Created on : Sep 21, 2019, 2:50:15 PM
    Author     : SE130226
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!-- saved from url=(0043)http://us-123sushi.simplesite.com/410908035 -->
<html lang="en-US" class=""><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu and Price list - us-123sushi.simplesite.com</title>
        <meta property="og:site_name" content="The Sushi Restaurant">
        <meta property="article:publisher" content="https://www.facebook.com/simplesite">
        <meta property="og:locale" content="en-US">
        <meta property="og:url" content="http://us-123sushi.simplesite.com/410908035">
        <meta property="og:title" content="Menu and Price list">
        <meta property="og:updated_time" content="2016-06-18T11:16:30.5603643+02:00">
        <meta property="og:type" content="website">
        <meta name="robots" content="nofollow">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="The Sushi Restaurant - http://us-123sushi.simplesite.com/">
        <link rel="stylesheet" type="text/css" href="./Menu and Price list - us-123sushi.simplesite.com_files/3627058.design.v25490.css">
        <link rel="canonical" href="http://us-123sushi.simplesite.com/410908035">
        <link rel="shortcut icon" href="data:image/x-icon;,">
        <script type="text/javascript" async="" src="./Menu and Price list - us-123sushi.simplesite.com_files/analytics.js"></script><script async="" src="./Menu and Price list - us-123sushi.simplesite.com_files/gtm.js"></script><script type="text/javascript" src="./Menu and Price list - us-123sushi.simplesite.com_files/FrontendAppLocalePage.aspx"></script>
        <script type="text/javascript" src="./Menu and Price list - us-123sushi.simplesite.com_files/frontendApp.min.js"></script>
        <script type="text/javascript">if (typeof window.jQuery == "undefined") {
                (function () {
                    var a = document.createElement("script");
                    a.type = "text/javascript";
                    a.src = "/c/js/version3/frontendApp/init/frontendApp.min.js?_v=b8e7069b6e4fecc37c8394dc153e5d4f";
                    document.getElementsByTagName('head')[0].appendChild(a);
                })();
            }</script>

        <script type="text/javascript">var css_simplesite_com_fallback_element = document.getElementById('css_simplesite_com_fallback');
            if (typeof css_simplesite_com_fallback_element !== 'undefined' && css_simplesite_com_fallback_element !== null) {
                var isVisible = css_simplesite_com_fallback_element.offsetParent !== null
                if (isVisible) {
                    var head = document.head, link = document.createElement('link');

                    link.type = 'text/css';
                    link.rel = 'stylesheet';
                    link.href = '{/d/designs/3627058.design.v25490.css}';

                    head.appendChild(link);
                }
            }</script>
        <style type="text/css">.fancybox-margin{margin-right:17px;}</style></head>
    <body data-pid="410908035" data-iid="">


        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <div class="container-fluid header-wrapper " id="header"> <!-- this is the Header Wrapper -->
                <div class="container">
                    <div class="title-wrapper">
                        <div class="title-wrapper-inner">
                            <a rel="nofollow" class="logo " href="http://us-123sushi.simplesite.com/">

                            </a>
                            <div class="title ">
                                The Sushi Restaurant
                            </div>
                            <div class="subtitle">
                                Welcome to this website
                            </div>
                        </div>
                    </div>  <!-- these are the titles -->
                    <div class="navbar navbar-compact">
                        <div class="navbar-inner">
                            <div class="container">
                                <!-- .btn-navbar is used as the toggle for collapsed navbar content -->
                                <a rel="nofollow" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse" title="Toggle menu">
                                    <span class="menu-name">Menu</span>
                                    <span class="menu-bars">
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </span>
                                </a>



                                <!-- Everything you want hidden at 940px or less, place within here -->
                                <div class="nav-collapse collapse">
                                    <ul class="nav" id="topMenu" data-submenu="horizontal">
                                        <li class="  " style="">
                                            <a rel="nofollow" href="LoadController">Home</a>
                                        </li>
                                        <li class=" active " style="">
                                            <a rel="nofollow" href="MenuLoadController">Menu and Price list</a>
                                        </li>
                                        <li class="  " style="">
                                            <a rel="nofollow" href="InfoLoadController?infoId=1">Find us</a>
                                        </li>                
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- this is the Menu content -->
                </div>
            </div>  <!-- this is the Header content -->

            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper list list-prices">
                                <div class="heading">
                                    <h1 class="page-title">Menu and Price list</h1>
                                </div>

                                <div class="content">
                                    <c:if test="${requestScope.MENUS != null}">
                                        <c:if test="${requestScope.MENUS.size() > 0}">
                                            <c:forEach items="${requestScope.MENUS}" var="menu" varStatus="count">
                                                <div class="section">
                                                    <div class="content">
                                                        <table class="table">
                                                            <thead>
                                                                <tr>
                                                                    <th>Menu ${count.count}</th>
                                                                    <th class="align-right">Price</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td>${menu.name}</td>
                                                                    <td class="align-right">€${menu.price}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                        <p>${menu.description}</p>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div id="right" class="span3">
                            <div class="sidebar">
                                <div class="wrapper share-box">
                                    <div class="heading">
                                        <h4>Share this page</h4>
                                    </div>

                                    <div class="content">
                                        <span>
                                            <ul>
                                                <li><a id="share-facebook" href="http://us-123sushi.simplesite.com/410908035#"><i class="icon-facebook-sign"></i><span>Share on Facebook</span></a></li>
                                                <li><a id="share-twitter" href="http://us-123sushi.simplesite.com/410908035#"><i class="icon-twitter-sign"></i><span>Share on Twitter</span></a></li>
                                                <li><a id="share-google-plus" href="http://us-123sushi.simplesite.com/410908035#"><i class="icon-google-plus-sign"></i><span>Share on Google+</span></a></li>    
                                            </ul>

                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>  <!-- the controller has determined which view to be shown in the content -->

                <div class="container-fluid footer-wrapper" id="footer"> <!-- this is the Footer Wrapper -->
                    <div class="container">
                        <div class="footer-info">
                            <div class="footer-powered-by">
                                <a rel="nofollow" href="http://www.simplesite.com/">Created with SimpleSite</a>
                            </div>
                        </div>
                        <div class="footer-page-counter" style="display: block;">
                            <span class="footer-page-counter-item">0</span>

                            <span class="footer-page-counter-item">2</span>

                            <span class="footer-page-counter-item">5</span>

                            <span class="footer-page-counter-item">5</span>

                            <span class="footer-page-counter-item">5</span>

                            <span class="footer-page-counter-item">3</span>
                        </div>
                        <div id="css_simplesite_com_fallback" class="hide"></div>
                    </div>
                </div>  <!-- this is the Footer content -->
            </div>


            <input type="hidden" id="anti-forgery-token" value="vFZIp11QDd7w1cZjYdzwVVw3rTHgQi1lpMMqomvLq/qGfx85dADIn6rd+jb5+yvdIjnIKNejlFu6vxL7J8Np5XDrvUyMasUYb8PZlmgROpWgWhFTGjCoyYPRNAZ57HUVr4c6QnvYhoYJLJG8dWLP2NhmdVJF+RhKEwkT1Q7ogGGTSddnANm69E10QsexY3DV5L0XqDr1VHHaGc7ZSxM2ktc82EJ4KYkwEXssuv2a0gNK9Zc8XKu5Ft28qiKVqNsj3YTpteTqb5UM9+U6Dtk4R+nJWQ1rw7NgjMDh9hCABmCHxgiQJBhPooojs3CleKjorvDjhc1vLhNfhEdOaEJSAXy1zHip7yoxj/Ybn86swSis7wnW/YTVdMos5ci15FQjLXy+AuwYhuwHWlhNM8crwlL8LfD8fInczpocUZB/gq+On5MuQGNWwqKf9Pt25ydY1ciKiD1Em/UU5lv75cbFPg==">


            <script>
                dataLayer = [{"SiteVer": "US", "MainOrUser": "UserPage", "PreOrFre": "Free", "Language": "en", "Culture": "en-US", "Instrumentation": "ShowPage", "Market": "DK"}];
            </script>
            <!-- Google Tag Manager -->
            <noscript>&lt;iframe src="//www.googletagmanager.com/ns.html?id=GTM-2MMH"
            height="0" width="0" style="display:none;visibility:hidden"&gt;&lt;/iframe&gt;</noscript>
            <script>(function (w, d, s, l, i) {
                    {
                        w[l] = w[l] || [];
                        w[l].push({'gtm.start':
                                    new Date().getTime(), event: 'gtm.js'});
                        var f = d.getElementsByTagName(s)[0],
                                j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
                        j.async = true;
                        j.src =
                                '//www.googletagmanager.com/gtm.js?id=' + i + dl;
                        f.parentNode.insertBefore(j, f);
                    }
                })(window, document, 'script', 'dataLayer', 'GTM-2MMH');</script>
            <!-- End Google Tag Manager -->


            <!-- Remove after blog exp concludes -->
            <!-- Remove after expeirment is done-->

            <div id="sm2-container" class="movieContainer high_performance" style="z-index: 10000; position: fixed; width: 8px; height: 8px; bottom: 0px; left: 0px; overflow: hidden; visibility: hidden;"><embed name="sm2movie" id="sm2movie" src="/Images/sm297/soundmanager2_flash9.swf" quality="high" allowscriptaccess="always" bgcolor="#ffffff" pluginspage="www.macromedia.com/go/getflashplayer" title="JS/Flash audio component (SoundManager 2)" type="application/x-shockwave-flash" wmode="transparent" haspriority="true"></div></body></html>
