<%@include file="headerAndTopNavigation.jsp"%>

<div class="container">

    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <hr>
                <h2 class="intro-text text-center">Submit a complete<br />
                    <strong>Story</strong>
                </h2>
                <hr>
            </div>
            <div class="col-md-6">
                <img class="img-responsive img-border-left" src="img/slide-2.jpg" alt="">
            </div>
            <div class="col-md-6">
                <p>Put your creative skills to work.</p>
                <p>Compose your complete story here or paste it from another source.</p>
                <p>Go wild, give root to your dreams. Just remember, this is a community. Your submission must be YOURS,
                    a complete story (don't leave readers hanging) and must follow the FanFic Interactive
                    <a href="rulesAndregulations.jsp">rules and regulations</a>
                    to avoid being flagged and subsequently deleted.</p>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>

    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center"><strong>Tell your story</strong><br /></h2>
                    <hr>
                    <h6 class="clickForAdditionalInformation_TopicHeader text-center"
                        id="getThingsToRememberInformation"
                        onclick="toggleExplanation(7)">Things to remember</h6>
                </div>
                <div class="col-lg-12">
                    <form>

                        <div class="form-group"> <!-- title field -->
                            <label class="control-label " for="storyTitle">Story Title</label>
                            <input class="form-control" id="storyTitle" name="storyTitle" type="text" maxlength="55"/>
                            <h6 class="clickForAdditionalInformation"
                                id="getTitleInformation"
                                onclick="toggleExplanation(1);">Guidelines for Titles</h6>
                        </div>

                        <div class="form-group"> <!-- description field -->
                            <label class="control-label requiredField" for="storyShortDescription">One sentence summary</label>
                            <input class="form-control" id="storyShortDescription" name="storyShortDescription" type="text" maxlength="255"/>
                            <h6 class="clickForAdditionalInformation"
                                id="getDescriptionInformation"
                                onclick="toggleExplanation(2)">Rules for descriptions</h6>
                        </div>

                        <div class="form-group"> <!-- ageRating field -->
                            <label class="control-label requiredField" for="ageRating">Story is appropriate for ages over</label>
                            <input class="form-control" id="ageRating" name="ageRating" type="text" maxlength="2"
                                    placeholder="An age between 0 and 21 years. "/>
                            <h6 class="clickForAdditionalInformation"
                                id="getRatingInformation"
                                onclick="toggleExplanation(3);">How the age rating works</h6>
                        </div>
<!--
 <!--                       <div class="form-group"> <!-- original or derivative radio buttons -->
                        <!--                            <label class="control-label">Story content is . . .
                                                        <label class="radio">
                                                            <input value="derivative"
                                                                   name="storyContentType"
                                                                   type="radio">derivative
                                                        </label>
                                                        <h6 class="clickForAdditionalInformation"
                                                              id="getDerivativeInformation"
                                                              onclick="toggleExplanation(4)">explain this</h6>
                                                        <label class="radio">
                                                            <input value="original"
                                                                   name="storyContentType"
                                                                   type="radio">original
                                                        </label>
                                                        <h6 class="clickForAdditionalInformation"
                                                              id="getOriginalInformation"
                                                              onclick="toggleExplanation(5)">explain this</h6>
                                                    </label>
                                                </div>

                        -->

                        <label class="control-label">Story content is . . .
                        <div class=".btn-group-vertical" data-toggle="buttons"> <!-- original or derivative radio buttons -->

                                <label class="btn btn-primary intro-text">
                                    <input type="radio" name="options" id="option1" autocomplete="off" > derivative
                                </label><br />
                                <h6 class="clickForAdditionalInformation"
                                    id="getDerivativeInformation"
                                    onclick="toggleExplanation(4)">explain this</h6>

                                <label class="btn btn-primary intro-text">
                                    <input type="radio" name="options" id="option2" autocomplete="off"> original
                                </label>


                                <h6 class="clickForAdditionalInformation"
                                    id="getOriginalInformation"
                                    onclick="toggleExplanation(5)">explain this</h6>


                        </div>
                        </label>




                        <hr>

                        <div class="form-group"> <!-- story field -->
                            <label class="control-label " for="story">Story</label>
                            <h6 class="clickForAdditionalInformation"
                                id="getStoryInformation"
                                onclick="toggleExplanation(6)">Rules for stories</h6>
                            <textarea class="form-control" cols="40" id="story" name="story" rows="10"></textarea>
                        </div>

                        <div class="form-group">
                            <button class="btn btn-primary " name="submit" type="submit">Submit</button>
                        </div>

                    </form>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>

</div>
<!-- /.container -->

<%@include file="footer.jsp"%>
