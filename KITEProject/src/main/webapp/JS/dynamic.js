$(document).ready(function () {
    function addItem(inputId, buttonId, listId) {
        // Add item to list on button click
        $("#" + buttonId).click(function () {
            const itemText = $("#" + inputId).val();

            if (itemText.trim()) {
                const listItem = $("<li>").text(itemText);
                $("<button>")
                    .text("Remove")
                    .click(function () {
                        $(this).parent().remove();
                    })
                    .appendTo(listItem);

                $("#" + listId).append(listItem);
                $("#" + inputId).val("");
            }
        });

        // Add item to list on pressing Enter key
        $("#" + inputId).keypress(function (e) {
            if (e.which === 13) {
                e.preventDefault();
                $("#" + buttonId).click();
            }
        });
    }

    // Initialize each input and button pair
    addItem("inputText", "addButton", "dynamicList");
    addItem("inputText1", "addButton1", "dynamicList1");
    addItem("inputText2", "addButton2", "dynamicList2");
});