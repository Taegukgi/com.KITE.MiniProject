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
  addItem("inputText", "addButton", "obligation");
  addItem("inputText1", "addButton1", "obligation1");
  addItem("inputText2", "addButton2", "obligation2");
  addItem("inputText3", "addButton3", "obligation3");
  addItem("inputText4", "addButton4", "obligation4");
  addItem("inputText5", "addButton5", "obligation5");
  addItem("inputText6", "addButton6", "obligation6");
  addItem("inputText7", "addButton7", "obligation7");
  addItem("inputText8", "addButton8", "obligation8");
  addItem("inputText9", "addButton9", "obligation9");
  addItem("inputText10", "addButton10", "obligation10");
  addItem("inputText11", "addButton11", "obligation11");
  addItem("inputText12", "addButton12", "obligation12");
});
