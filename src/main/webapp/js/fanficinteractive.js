



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
                Since Fan Fic Interactive happily accepts both original and derived content, knowing which is which \
                helps us categorize your work so that it is easier for readers to find in our library.';
            break;

        case 5 :
            iD ="getOriginalInformation";
            topic = "explain this";
            explanation = 'Original here means something completely your own and not based on anything else. Yes, we realize \
                that your great fanFic adaptions are your original creation, but the world in which they are based or the characters \
                portrayed extend the work of another author. Picking the right type of content will help categorize your story \
                in the Fan Fic Interactive library.';
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

        default : alert('a problem has occurred in toggleExplanation method');
    }

    currentPhrase = document.getElementById(iD).innerHTML;
    if (currentPhrase === topic) {
        document.getElementById(iD).innerHTML = explanation;
    } else {
        document.getElementById(iD).innerHTML = topic;
    }
}


function giveInputLine() {
    document.getElementById()
}


