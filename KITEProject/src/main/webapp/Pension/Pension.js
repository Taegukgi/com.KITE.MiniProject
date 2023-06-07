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
                        $(this).parent().fadeOut(300, function () {
                            $(this).remove();
                        });
                    })
                    .appendTo(listItem);

                $("#" + listId).append(listItem.hide().fadeIn(300));
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

    function addPensionAmount(inputId, buttonId, listId) {
        $("#" + buttonId).click(function () {
            const pensionAmount = parseFloat($("#" + inputId).val());

            if (!isNaN(pensionAmount) && pensionAmount > 0) {
                const taxRate = 0.15; // 나라별 세율 적용가능 함.

                // 연금을 한달단위 받을 경우 세금 계산
                const monthlyAmount = pensionAmount;
                const monthlyTax = monthlyAmount * taxRate;
                const netMonthlyAmount = monthlyAmount - monthlyTax;

                // 연금을 년 단위로 받을 경우 세금 계산
                const yearlyAmount = monthlyAmount * 12;
                const yearlyTax = yearlyAmount * taxRate;
                const netYearlyAmount = yearlyAmount - yearlyTax;

                const listItem = $("<li>");
                listItem.append(
                    $("<span>").addClass("result").text(`Monthly (before tax): ${monthlyAmount.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`),
                    " | ",
                    $("<span>").addClass("result").text(`Monthly tax: ${monthlyTax.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`),
                    " | ",
                    $("<span>").addClass("result").text(`Monthly (after tax): ${netMonthlyAmount.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`),
                    "<br>",
                    $("<span>").addClass("result").text(`Yearly (before tax): ${yearlyAmount.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`),
                    " | ",
                    $("<span>").addClass("result").text(`Yearly tax: ${yearlyTax.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`),
                    " | ",
                    $("<span>").addClass("result").text(`Yearly (after tax): ${netYearlyAmount.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`)
                );
                $("#" + listId).html(listItem);

                $("#" + inputId).val("");
            }
        });

        $("#" + inputId).keypress(function (e) {
            if (e.which === 13) {
                e.preventDefault();
                $("#" + buttonId).click();
            }
        });
    }

    // Initialize each input and button pair
    addItem("inputText", "addButton", "pension");
    addItem("inputText1", "addButton1", "pension1");
    addItem("inputText2", "addButton2", "pension2");
    addItem("inputText3", "addButton3", "pension3");
    

    addPensionAmount("inputText4", "addButton4", "pension4");
});

