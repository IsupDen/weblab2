let graph;
let form;

function loadGraph() {
    graph = document.querySelector('#graph-svg').getSVGDocument();
    points.forEach(function (point) {
        graph.querySelector('#point').before(point);
    })
    graph.addEventListener('click', function (event) {
        let x = event.x;
        let y = event.y;
        if (validateR()) {
            x = (x - 150) / 30;
            y = (150 - y) / 30;
            xField.value = Number(x.toFixed(5));
            yField.value = Number(y.toFixed(5));
            form.submit();
        }
    })
    document.querySelector('#time-zone-field').value = (new Date()).getTimezoneOffset()
}