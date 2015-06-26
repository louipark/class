                $(document).ready(function () {
                    $("#my-calendar").zabuto_calendar({
					today: true,
					ajax: { url: "show_data.php", modal: true}
					});
                });