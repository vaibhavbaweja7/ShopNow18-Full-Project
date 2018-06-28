<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page isELIgnored="false" %><html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>




</head>
<body style="background-image:url(https://inspirationhut.net/wp-content/uploads/2013/05/201.png)">
<jsp:include page="Header.jsp" />

  <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src= "data:image/jpeg;base64,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" >
    </div>

    <div class="item">
      <img src="https://md5.pricebaba.com/images/product/mobile/35040/motorola-moto-x4-xxl.jpg" alt="Chicago">
    </div>

    <div class="item">
      <img src="https://i.kinja-img.com/gawker-media/image/upload/s--pT4RGng9--/c_scale,f_auto,fl_progressive,q_80,w_800/sinpooscwadbvaangh7i.jpg" alt="New York">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<div class="container">
<div class="a-section as-title-block">

    <h2 class="as-title-block-left">
     <span class="a-color-base">
Deals recommended for you
     </span>
    </h2> 
<div id="wrap">
<img src="https://image.dhgate.com/0x0/f2/albu/g5/M01/2A/0D/rBVaJFmRERWAUfMcAAK3o1ZdtXw259.jpg" alt="Norway" style="width:25%"class="img-circle" >
 <img src="https://images-na.ssl-images-amazon.com/images/I/5123M2VGGKL._SX306_BO1,204,203,200_.jpg" alt="Harry" style="width:25% " class="img-rounded">
<img src="https://img.grouponcdn.com/deal/44MJFFqo3tSU43PjZeCdk5zPKbX3/44-960x582/v1/c700x420.jpg" alt="beard" style="width:25%" class="img-rounded">
<img src="https://storefeederimages.blob.core.windows.net/inkstitchltd/Products/30e39333-aec8-41b2-bf6c-41b48dd47041/Full/qwlwl102v10.jpg" alt="groot" style="width:20%"class="img-rounded">
</div>


<!--Footer-->
<footer class="page-footer font-small unique-color-dark pt-0">

    <div style="background-color: #6351ce;">
        <div class="container">
            <!--Grid row-->
            <div class="row py-4 d-flex align-items-center">

                <!--Grid column-->
                <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
                    <h6 class="mb-0 white-text">Get connected with us on social networks!</h6>
                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-md-6 col-lg-7 text-center text-md-right">
                    <!--Facebook-->
                    <a class="fb-ic ml-0">
                        <i class="fa fa-facebook white-text mr-lg-4"> </i>
                    </a>
                    <!--Twitter-->
                    <a class="tw-ic">
                        <i class="fa fa-twitter white-text mr-lg-4"> </i>
                    </a>
                    <!--Google +-->
                    <a class="gplus-ic">
                        <i class="fa fa-google-plus white-text mr-lg-4"> </i>
                    </a>
                    <!--Linkedin-->
                    <a class="li-ic">
                        <i class="fa fa-linkedin white-text mr-lg-4"> </i>
                    </a>
                    <!--Instagram-->
                    <a class="ins-ic">
                        <i class="fa fa-instagram white-text mr-lg-4"> </i>
                    </a>
                </div>
                <!--Grid column-->

            </div>
            <!--Grid row-->
        </div>
    </div>

    <!--Footer Links-->
    <div class="container mt-5 mb-4 text-center text-md-left">
        <div class="row mt-3">

            <!--First column-->
            <div class="col-md-3 col-lg-4 col-xl-3 mb-4">
                <h6 class="text-uppercase font-weight-bold">
                    <strong>Company name</strong>
                </h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>Here you can use rows and columns here to organize your footer content. Lorem ipsum dolor sit
                    amet, consectetur adipisicing elit.</p>
            </div>
            <!--/.First column-->

            <!--Second column-->
            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                <h6 class="text-uppercase font-weight-bold">
                    <strong>Products</strong>
                </h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a href="#!">MDBootstrap</a>
                </p>
                <p>
                    <a href="#!">MDWordPress</a>
                </p>
                <p>
                    <a href="#!">BrandFlow</a>
                </p>
                <p>
                    <a href="#!">Bootstrap Angular</a>
                </p>
            </div>
            <!--/.Second column-->

            <!--Third column-->
            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                <h6 class="text-uppercase font-weight-bold">
                    <strong>Useful links</strong>
                </h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a href="#!">Your Account</a>
                </p>
                <p>
                    <a href="#!">Become an Affiliate</a>
                </p>
                <p>
                    <a href="#!">Shipping Rates</a>
                </p>
                <p>
                    <a href="#!">Help</a>
                </p>
            </div>
            <!--/.Third column-->

            <!--Fourth column-->
            <div class="col-md-4 col-lg-3 col-xl-3">
                <h6 class="text-uppercase font-weight-bold">
                    <strong>Contact</strong>
                </h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <i class="fa fa-home mr-3"></i> New York, NY 10012, US</p>
                <p>
                    <i class="fa fa-envelope mr-3"></i> info@example.com</p>
                <p>
                    <i class="fa fa-phone mr-3"></i> + 01 234 567 88</p>
                <p>
                    <i class="fa fa-print mr-3"></i> + 01 234 567 89</p>
            </div>
            <!--/.Fourth column-->

        </div>
    </div>
    <!--/.Footer Links-->

    <!-- Copyright-->
    <div class="footer-copyright py-3 text-center">
        © 2018 Copyright:
        <a href="https://mdbootstrap.com/material-design-for-bootstrap/">
            <strong> MDBootstrap.com</strong>
        </a>
    </div>
    <!--/.Copyright -->

</footer>
<!--/.Footer-->
                      

</body>
</html>