(function($) {
    "use strict"; // Start of use strict
    //tab click
    $("#job-tab a, #job-status-tab a").click(function(e) {
        e.preventDefault();
        $(this).tab("show");
        multiplyNode();
    });

    function Reset() {
        document.getElementById("form1").reset();
    }
    // Please do not use inline event handlers, use this instead:
    // document.getElementById("resetBtn").onclick = function() {
    //     Reset();
    // }



    // Toggle the side navigation
    $("#sidebarToggle, #sidebarToggleTop").on('click', function(e) {
        $("body").toggleClass("sidebar-toggled");
        $(".sidebar").toggleClass("toggled");
        if ($(".sidebar").hasClass("toggled")) {
            $('.sidebar .collapse').collapse('hide');
        };
    });

    // Close any open menu accordions when window is resized below 768px
    $(window).resize(function() {
        if ($(window).width() < 768) {
            $('.sidebar .collapse').collapse('hide');
        };

        // Toggle the side navigation when window is resized below 480px
        if ($(window).width() < 480 && !$(".sidebar").hasClass("toggled")) {
            $("body").addClass("sidebar-toggled");
            $(".sidebar").addClass("toggled");
            $('.sidebar .collapse').collapse('hide');
        };
    });

    // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
    $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function(e) {
        if ($(window).width() > 768) {
            var e0 = e.originalEvent,
                delta = e0.wheelDelta || -e0.detail;
            this.scrollTop += (delta < 0 ? 1 : -1) * 30;
            e.preventDefault();
        }
    });

    // Scroll to top button appear
    $(document).on('scroll', function() {
        var scrollDistance = $(this).scrollTop();
        if (scrollDistance > 100) {
            $('.scroll-to-top').fadeIn();
        } else {
            $('.scroll-to-top').fadeOut();
        }
    });

    // Smooth scrolling using jQuery easing
    $(document).on('click', 'a.scroll-to-top', function(e) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($anchor.attr('href')).offset().top)
        }, 1000, 'easeInOutExpo');
        e.preventDefault();
    });

    $(function() {
        $('#datepicker').datepicker();
    });


    const dates = [`<input type='date' />  <span>clear</span>`];

    function render() {
        for (let i = 0; i < dates.length; i++) {
            $("#add-date").append(dates[i])
        }
    }
    render()

    if (document.getElementById("addsection")) {
        document.getElementById("addsection").onclick = function() {
            // var container = document.getElementById("add-date");
            // var section = document.getElementById("datepicker");
            // container.appendChild(section.cloneNode(true));
            $("#add-date").empty()
            dates.push(`<input type='date' />  <span>clear</span>`)

            render()
        }

    }
    // $('.datepicker').datepicker({
    //     labelMonthNext: 'Go to the next month',
    //     labelMonthPrev: 'Go to the previous month',
    //     labelMonthSelect: 'Pick a month from the dropdown',
    //     labelYearSelect: 'Pick a year from the dropdown',
    //     selectMonths: true,
    //     selectYears: true
    // })

    



})(jQuery); // End of use strict