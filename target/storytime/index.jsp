<%@include file="taglib.jsp"%>
<c:set var="title" value="Index Page" />
<%@include file="headerAndTopNavigation.jsp"%>

<div class="container">

    <div class="row">
        <div class="box">
            <div class="col-lg-12 text-center">
                <div id="carousel-example-generic" class="carousel slide">
                    <!-- Indicators -->
                    <ol class="carousel-indicators hidden-xs">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img class="img-responsive img-full" src="img/slide-1.jpg" alt="">
                        </div>
                        <div class="item">
                            <img class="img-responsive img-full" src="img/slide-2.jpg" alt="">
                        </div>
                        <div class="item">
                            <img class="img-responsive img-full" src="img/slide-3.jpg" alt="">
                        </div>
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                        <span class="icon-prev"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                        <span class="icon-next"></span>
                    </a>
                </div>
                <h2 class="brand-before">
                    <small>Welcome to</small>
                </h2>
                <h1 class="brand-name">TwistedTrail</h1>
                <hr class="tagline-divider">
                <h2>
                    <small>By
                        <strong>Awesome Aaron</strong>
                    </small>
                </h2>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <hr>
                <h2 class="intro-text text-center">Control. Yeah, wouldn't you love to have some control
                    over fate? I think we all would, and now your chance
                    <strong>is here</strong>
                </h2>
                <hr>
                <img class="img-responsive img-border img-left" src="img/intro-pic.jpg" alt="">
                <hr class="visible-xs">
                <p>We are fans of books and movies for a reason; we love to shove the blah-bland world
                    of everyday to the back burner and step away into a world that is just a bit more
                    . . . interesting.</p>
                <p>Books and movies are great, but deep down inside, a part of every one of us wants to get just a bit closer.
                        A little part of us is always wishing that our favorite character would have turned left when
                        they turned right. Yeah, you know what I am saying. Not to say that the original author didn't
                        get it quite right. It is just that, maybe, we would like to know what happened,
                        down the way, if that special left turn of our dreams would have come to pass.
                        And because that left turn, that little twist of fate, never happened, each of us
                        has a little hollow place inside that needs to be filled. 
                        With the help of the TwistedTrail community, you can twist fictional fate to your whims.</p>
                <p>So rejoice. Let your hollow place be filled!</p>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <hr>
                <h2 class="intro-text text-center">Check out the
                    <strong>newest, highest rated and most twisted content</strong>
                </h2>
                <hr>
                <p>Newest contributions</p>
                <ul>
                    <li>TODO__title date and what is new the story or the twist</li>
                    <li>TODO__title date and what is new the story or the twist</li>
                    <li>TODO__title date and what is new the story or the twist</li>
                </ul>
                <p>Highest rated</p>
                <ul>
                    <li>TODO__title rating</li>
                    <li>TODO__title rating</li>
                    <li>TODO__title rating</li>
                </ul>
                <p>Most twisted</p>
                <ul>
                    <li>TODO__title total twists</li>
                    <li>TODO__title total twists</li>
                    <li>TODO__title total twists</li>
                </ul>
            </div>
        </div>
    </div>

</div>
<!-- /.container -->

<%@include file="footer.jsp"%>

