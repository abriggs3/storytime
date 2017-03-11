



function toggleExplanation(questionNumber) {
    var iD;
    var topic;
    var explanation;
    var currentPhrase;

    switch (questionNumber){
        case 1 :
            iD = "getTitleInformation";
            topic = "Guidelines for Titles";
            explanation = 'Titles have a maximum length of 55 characters.<br /> \
                Be courteous and appropriate in your word use. Titles are viewable by everyone.<br /> \
                Inappropriate titles will get flagged, then deleted, along with the story contents and any attached paths. \
                So if in doubt, err on the conservative, \'appropriate for all audiences\', side.';
            break;

        case 2 :
            iD = "getDescriptionInformation";
            topic = "Rules for descriptions";
            explanation = 'This should be a very brief, maximum 255 characters, summary of your story.<br /> \
                Much like titles, descriptions are viewable by anyone, so be appropriate in your wording. Even \
                if your story is intended for mature readers, your description must be no worse than PG or you \
                will risk being flagged and deleted. This deletes your story and all paths attached.';
            break;

        case 3 :
            iD = "getRatingInformation";
            topic = "How the age rating works";
            explanation = 'An age of 0 means appropriate for everyone.<br /> \
                Note: final age rating is based on an average of ratings from all readers who rate your story. \
                don\'t be surprised or offended if the rating of your story changes based on public opinion.';
            break;

        case 4 :
            iD = "getDerivativeInformation";
            topic = "explain this";
            explanation = 'A derivative story is derived from, or based on, someone else\'s work. By definition, all fan fiction is derivative. \
                Since TwistedTrail happily accepts both original and derived content, knowing which is which \
                helps us categorize your work so that it is easier for readers to find in our library. Choosing \'derivative\' \
                will produce a genre list. The genres in this list are specific to derivative literature an not related to \
                the typical \'classical\' literary genres.';
            break;

        case 5 :
            iD ="getOriginalInformation";
            topic = "explain this";
            explanation = 'Original here means something completely your own and not based on anything else. Yes, we realize \
                that your great fan fiction adaptions are your original creation, but the world in which they are based or the characters \
                portrayed extend the work of another author. Picking the right type of content will help categorize your story \
                in the TwistedTrail library.';
            break;

        case 6 :
            iD = "getStoryInformation";
            topic = "Rules for stories";
            explanation = 'Specific guidelines for stories are covered in <a href="rulesAndregulations.jsp">rules and regulations</a>.<br /> \
                In general, FanFic Interactive seeks to have as little involvement in your creative process as possible. \
                Your fellow contributors will act as peer moderators rating your stories for quality and age appropriateness. \
                So, go ahead let loose, have fun, and get creative.';
            break;

        case 7 :
            iD = "getThingsToRememberInformation";
            topic = "Things to remember";
            explanation = 'Things to remember<br /> \
                Type or paste your plain text story in the box, and submit.<br /> \
                If you are not logged in, you will be prompted to do so.<br /> \
                Once you hit submit, your story is committed and can NOT be changed.<br /> \
                As note, you can delete your story as long no paths have been added.<br /> \
                To preserve the paths others may have added to your story, only a site administrator<br /> \
                can delete your story if another user has added a path to it.';
            break;

        default : alert('a problem has occurred in toggleExplanation function');
    }

    currentPhrase = document.getElementById(iD).innerHTML;
    if (currentPhrase === topic) {
        document.getElementById(iD).innerHTML = explanation;
    } else {
        document.getElementById(iD).innerHTML = topic;
    }
}


function getDropdown(dropdownNumber) {
    var storyContentDropdownLocation;
    var removeContentFromLocation;
    var content;

    switch (dropdownNumber) {
        case 1 :
            storyContentDropdownLocation = "storyContentDropdown1";
            removeContentFromLocation = "storyContentDropdown2"
            content = '<div class="form-group selectpicker" data-style="btn-primary"> \
                           <select name="derivativeDropdown"> \
                                <option value="noSelect">select a derivative genre</option> \
                                <option value="adventure">adventure</option> \
                                <option value="hurt">hurt/comfort</option> \
                                <option value="mystery">mystery</option> \
                                <option value="romance">romance</option> \
                                <option value="slash">slash</option> \
                                <option value="songfic">songfic</option> \
                                <option value="crossover">crossover</option> \
                                <option value="marysue">marysue</option> \
                           </select> \
                      </div> \
                      <div form-group"> \
                           <label class="control-label requiredField" for="derivedFromDerivative">Original work story is derived from . . . <br /></label> \
                                Use the EXACT main title, including \'the\' when required i.e. <em>The</em> Vampire Diaries. \
                                Don\'t include subtitles. \
                           <input class="form-control col-lg-12" id="derivedFromDerivative" name="derivedFromDerivative" type="text" maxlength="255" \
                                 placeholder="Exact title, up to 255 characters"/> \
                      </div>';
            break;

        case 2 :
            storyContentDropdownLocation = "storyContentDropdown2";
            removeContentFromLocation = "storyContentDropdown1";
            content = '<div class="form-group selectpicker" data-style="btn-primary"> \
                           <select name="originalDropdown"> \
                                <option value="noSelect">select a original genre</option> \
                                <option value="action">action</option>\
                                <option value="adventure">adventure</option>\
                                <option value="comedy">comedy</option> \
                                <option value="tragicomedy">tragic comedy</option> \
                                <option value="drama">drama</option> \
                                <option value="horror">horror</option> \
                                <option value="mystery">mystery</option>\
                                <option value="romance">romance</option> \
                                <option value="romancecomedy">rom com</option> \
                                <option value="realistic">realistic fiction</option> \
                                <option value="satire">satire</option> \
                                <option value="fantasy">fantasy</option> \
                           </select> \
                      </div> \
                      <div form-group"> \
                           <label class="control-label requiredField" for="customGenre">Some stories don\'t \
                                    fit easily into a common genre. If this applies to your story, pick the closest genre from \
                                    dropdown menu and add a custom genre. Be brief, you have 55 characters. Remember, \
                                    you still must select a common genre, even if you add your own custom one.</label> \
                           <input class="form-control col-lg-12" id="customGenre" name="customGenre" type="text" maxlength="55" \
                                 placeholder="Your custom genre."/> \
                      </div>';
            break;
        default : alert('a problem has occurred in the getDropdown function');

    }
    document.getElementById(storyContentDropdownLocation).innerHTML = content;
    document.getElementById(removeContentFromLocation).innerHTML = "";
}

function validateForm2() {


    var derivativeDropdown = document.forms["submitStoryForm"]["derivativeDropdown"].value;
    var derivedFromDerivative = document.forms["submitStoryForm"]["derivedFromDerivative"].value;
    var originalDropdown = document.forms["submitStoryForm"]["originalDropdown"].value;
    var customGenre = document.forms["submitStoryForm"]["customGenre"].value;

}

function validateForm() {
    var storyTitle = (document.forms["submitStoryForm"]["storyTitle"].value).trim();
    var storyShortDescription = document.forms["submitStoryForm"]["storyShortDescription"].value.trim();
    var ageRating = document.forms["submitStoryForm"]["ageRating"].value.trim();

    var story = document.forms["submitStoryForm"]["story"].value.trim();
    var wordCount;
    var paragraphCount;

    var formFieldArray = [storyTitle, storyShortDescription, ageRating, story];
    var formFieldNameArray = ["Story Title", "One sentence summary", "Age Rating", "Story"];
    var formFieldIdArray =  ["storyTitle", "storyShortDescription", "ageRating", "story"];

    for (var index = 0; index < formFieldArray.length; index++) {
        if (formFieldArray[index] === "") {
            alert(formFieldNameArray[index] + " must be filled out");
            document.getElementById(formFieldIdArray[index]).focus();
            return false;
        }
    }

    if (isNaN(ageRating)) {
        alert("Age Rating must be a number.");
        document.getElementById("ageRating").focus();
        return false;
    }

    if (ageRating < 0 || ageRating > 21) {
        alert("Age Rating must be a number 0 through 21.");
        document.getElementById("ageRating").focus();
        return false;
    }


    paragraphCount = countParagraphs(story);
    if (paragraphCount < 5) {
        alert("Your story must have at least five paragraphs.");
        document.getElementById("story").focus();
        return false;
    }

    wordCount = countWords(story);
//TODO active this when testing is done   if (wordCount < 500) {
        if (wordCount < 5) {
        alert("Your story must have at least 500 words.");
        document.getElementById("story").focus();
        return false;
    }
}

function  countParagraphs(story) {
    return story.split(/\r?\n\r?\n/).length;
}

function countWords(story){
    story = story.replace(/[ ]{2,}/gi," ");
    story = story.replace(/\n /,"\n");
    return story.split(' ').length;
}

