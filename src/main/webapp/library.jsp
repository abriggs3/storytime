<%@ page import="aaron.briggs.persistence.DatabaseSelectProcessor"%>
<%@ page import="aaron.briggs.entity.Story" %>
<%@ page import="java.util.List" %>


<%@include file="taglib.jsp"%>
<c:set var="title" value="Library" />
<%@include file="headerAndTopNavigation.jsp"%>

<div class="container">

    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <hr>
                <h2 class="intro-text text-center">TwistedTrail
                    <strong>Library</strong>
                </h2>
                <hr>
            </div>
            <div class="col-lg-12 text-center">
                <img class="img-responsive img-border img-full" src="img/slide-1.jpg" alt="">
                <h2><small>Select a story from the library and</small>
                    <br>
                    Join the fun
                </h2>
                <p>Thanks to the collectively Twisted minds of all our TwistedTrail contributors, we have amassed  a
                        collection of interactive tales that will keep your interest piqued and place that finely woven
                        thread of fate directly into your sweaty little hands. If the choices you find within any story fail to
                        suit your tastes, make your own. At TwistedTrail you are in control. Like a force from
                        a Greek tragedy you can twist the path that lies ahead of your favorite character on a whim. Here
                    you are <em>deus ex machina</em>, the God from the Machine.</p>
                <p id="selectionButtons">Read. Enjoy. Let your voice be heard.</p>
                <a href="#newestStories" class="btn btn-default btn-sm custom-class">Newest Stories</a>
                <a href="#highestRatedStories" class="btn btn-default btn-sm custom-class">Highest Rated Stories</a>
                <a href="#mostTwistedStories" class="btn btn-default btn-sm custom-class">Most Twisted Stories</a>
                <hr>
            </div>


            <div id="newestStories" class="col-lg-4">
                <%!int limitValue = 5;%>
                <p>Top <%=limitValue%> Newest Stories </p>
                <ol>
                    <%! DatabaseSelectProcessor newestStories = new DatabaseSelectProcessor();
                        List<Story> newestStoryArrayList = newestStories.findAllStoriesByPublishedDate(limitValue);%>
                    <%  for (Story storyItem : newestStoryArrayList) {%>
                    <li><h5><a class="boldTitle" href="#"><%= storyItem.getStoryTitle()%></a></h5>
                            <p class="listItemDetails">
                                Date published: <%=storyItem.getStoryDatePublished()%><br />
                                Number of Paths: <%=storyItem.getStoryNumberOfPaths()%><br />
                                Author: <%= storyItem.getUserId()%><br />
                                Appropriate for ages: <%=storyItem.getStoryAgeRating()%>  and up. Number of ratings: <%=storyItem.getStoryNumberOfAgeRatings()%><br />
                                Content rating: <%=storyItem.getStoryRating()%> Number of ratings: <%=storyItem.getStoryNumberOfRatings()%><br />
                                Story type: <%=storyItem.getStoryType()%><br />
                                Genre: <%=storyItem.getStoryGenre()%><br />
                                Based on / Custom genre: <%=storyItem.getStoryBasedOnGenre()%><br />
                                Summary: <%=storyItem.getStorySummary()%><br />
                            </p>
                    </li>
                    <%}%>
                </ol>
                <a href="#selectionButtons" class="btn btn-default btn-sm custom-class">return to top</a>
            </div>

            <div id="highestRatedStories" class="col-lg-4">
                <p>Top <%=limitValue%> Highest Rated Stories </p>
                <ol>
                    <%! DatabaseSelectProcessor highestRatedStories = new DatabaseSelectProcessor();
                        List<Story> highestRatedStoriesArrayList = highestRatedStories.findAllStoriesByHighestRated(limitValue);%>
                    <%  for (Story storyItem : highestRatedStoriesArrayList) {%>
                    <li><h5><a class="boldTitle" href="#"><%= storyItem.getStoryTitle()%></a></h5>
                        <p class="listItemDetails">
                            Content rating: <%=storyItem.getStoryRating()%> Number of ratings: <%=storyItem.getStoryNumberOfRatings()%><br />
                            Date published: <%=storyItem.getStoryDatePublished()%><br />
                            Number of Paths: <%=storyItem.getStoryNumberOfPaths()%><br />
                            Author: <%= storyItem.getUserId()%><br />
                            Appropriate for ages: <%=storyItem.getStoryAgeRating()%>  and up. Number of ratings: <%=storyItem.getStoryNumberOfAgeRatings()%><br />
                            Story type: <%=storyItem.getStoryType()%><br />
                            Genre: <%=storyItem.getStoryGenre()%><br />
                            Based on / Custom genre: <%=storyItem.getStoryBasedOnGenre()%><br />
                            Summary: <%=storyItem.getStorySummary()%><br />
                        </p>
                    </li>
                    <%}%>
                </ol>
                <a href="#selectionButtons" class="btn btn-default btn-sm custom-class">return to top</a>
            </div>

            <div id="mostTwistedStories" class="col-lg-4">
                <p>Top <%=limitValue%> Most Twisted Stories </p>
                <ol>
                    <%! DatabaseSelectProcessor mostTwistedStories = new DatabaseSelectProcessor();
                        List<Story> mostTwistedStoriesArrayList = mostTwistedStories.findAllStoriesByMostTwisted(limitValue);%>
                    <%  for (Story storyItem : mostTwistedStoriesArrayList) {%>
                    <li><h5><a class="boldTitle" href="#"><%= storyItem.getStoryTitle()%></a></h5>
                        <p class="listItemDetails">
                            Number of Paths: <%=storyItem.getStoryNumberOfPaths()%><br />
                            Date published: <%=storyItem.getStoryDatePublished()%><br />
                            Author: <%= storyItem.getUserId()%><br />
                            Appropriate for ages: <%=storyItem.getStoryAgeRating()%>  and up. Number of ratings: <%=storyItem.getStoryNumberOfAgeRatings()%><br />
                            Content rating: <%=storyItem.getStoryRating()%> Number of ratings: <%=storyItem.getStoryNumberOfRatings()%><br />
                            Story type: <%=storyItem.getStoryType()%><br />
                            Genre: <%=storyItem.getStoryGenre()%><br />
                            Based on / Custom genre: <%=storyItem.getStoryBasedOnGenre()%><br />
                            Summary: <%=storyItem.getStorySummary()%><br />
                        </p>
                    </li>
                    <%}%>
                </ol>
                <a href="#selectionButtons" class="btn btn-default btn-sm custom-class">return to top</a>
            </div>
        </div>
    </div>
</div>
<!-- /.container -->
<%@include file="footer.jsp"%>