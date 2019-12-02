$('a').click(function (event) {
    event.preventDefault();
});

function getSelectedLabel(sel) {
    document.getElementById("store").storeName = sel.options[sel.selectedIndex].text;
    document.store.submit();
}