(function ($, window, document) {
    var createCommentButton = ".create-comment-button";
    var createCommentCourseSelect = "#comment-course-select";
    var createCommentCourseRating = "#comment-rating";
    var createCommentContent = "#comment-content";
    var searchCourseComment = "#course-filter";
    var courseSelectForm = "#course-select-form";
    var operationInput =  "#operation";

    var $CREATE_COMMENT_BUTTON = $(createCommentButton);
    var $CREATE_COMMENT_COURSE_SELECT = $(createCommentCourseSelect);
    var $CREATE_COMMENT_COURSE_RATING = $(createCommentCourseRating);
    var $CREATE_COMMENT_CONTENT = $(createCommentContent);
    var $SEARCH_COURSE_COMMENT = $(searchCourseComment);
    var $COURSE_SELECT_FORM = $(courseSelectForm);
    var $OPERATIONINPUT = $(operationInput);

    // if ($("#operationValue").val() != "") {
    //     $("#course-filter").val($("#operationValue").val());
    // }

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


        $SEARCH_COURSE_COMMENT.change(function () {
            var operation = 'getComments';
            if ($SEARCH_COURSE_COMMENT.val() === 'all') {
                operation = 'getAll';
            }
            $('#operation').val(operation);
            $COURSE_SELECT_FORM.submit();
        })


        // $SEARCH_COURSE_COMMENT.change(function () {
        //     var operation = 'getComments';
        //     if ($SEARCH_COURSE_COMMENT.val() === 'all') {
        //         operation = 'getAll';
        //     }
        //     var courseId = $SEARCH_COURSE_COMMENT.val();
        //     $.ajax({
        //         url: "/CommentController",
        //         method: "post",
        //         dataType: "json",
        //         data: {
        //             "operation": operation,
        //             "courseId": courseId
        //         }
        //     })
        //
        // })

    });

})(window.jQuery, window, document);
