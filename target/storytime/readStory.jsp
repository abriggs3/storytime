<%@include file="taglib.jsp"%>
<c:set var="title" value="Submit a Story" />
<%@include file="headerAndTopNavigation.jsp"%>

<div class="container">

    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <hr>
                <h2 class="intro-text text-center">the story author will be expressioned here ${author_readPage}<br />
                    <strong>${storyTitle_readPage}</strong>
                </h2>
                <hr>
            </div>
            <div class="col-md-6">
                <img class="img-responsive img-border-left" src="img/slide-2.jpg" alt="">
            </div>
            <div class="col-md-6">
                <p>${assembledStoryFragment_readPage}</p>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- /.container -->

<%@include file="footer.jsp"%>

