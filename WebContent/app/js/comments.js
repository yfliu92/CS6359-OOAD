(function ($, window, document) {
    var createCommentButton = ".create-comment-button";
    var createCommentCourseSelect = "#comment-course-select";
    var createCommentCourseRating = "#comment-rating";
    var createCommentContent = "#comment-content";

    var $CREATE_COMMENT_BUTTON = $(createCommentButton);
    var $CREATE_COMMENT_COURSE_SELECT = $(createCommentCourseSelect);
    var $CREATE_COMMENT_COURSE_RATING = $(createCommentCourseRating);
    var $CREATE_COMMENT_CONTENT = $(createCommentContent);

    $(function () {
        $('.student-teacher-comments').addClass('active');

        $CREATE_COMMENT_BUTTON.click(function () {
            var courseId = $CREATE_COMMENT_COURSE_SELECT.val();
            var rating = $CREATE_COMMENT_COURSE_RATING.val();
            var content = $CREATE_COMMENT_CONTENT.val();

            $.ajax({
                url: "/CommentController",
                method: "post",
                dataType: "json",
                data: {
                    "operation": "create",
                    "courseId": courseId,
                    "rating": rating,
                    "content": content
                },
                success: function (response) {
                    alert("Submit Success!");
                }
            })
        });
    });

})(window.jQuery, window, document);
