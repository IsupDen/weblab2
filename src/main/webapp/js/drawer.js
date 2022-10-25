function drawMainPoint(x, y) {
    graph.querySelector('#point').style.cx = 150 + 30 * x;
    graph.querySelector('#point').style.cy = 150 - 30 * y;
}

function changeCoord() {
    if (validateX() && validateY()) {
        drawMainPoint(xField.value, yField.value);
    }
}

function changeR() {
    if (validateR()) {
        const r = rField.value * 30;
        graph.querySelector('#rect').setAttribute('x', 150 - r);
        graph.querySelector('#rect').setAttribute('width', r);
        graph.querySelector('#rect').setAttribute('height', r);
        graph.querySelector('#circle').setAttribute('d', "M 150 150 L 150 " + (150-r/2) + " A 50 50 1 0 1 " + (150+r/2) + ",150 z");
        graph.querySelector('#triangle').setAttribute('d', "M 150 150 L " + (150+r/2) + " 150 L 150 " + (150+r) + " z");
        graph.querySelector('#first-x-tick').setAttribute('x1', 150 - r);
        graph.querySelector('#first-x-tick').setAttribute('x2', 150 - r);
        graph.querySelector('#second-x-tick').setAttribute('x1', 150 - r / 2);
        graph.querySelector('#second-x-tick').setAttribute('x2', 150 - r / 2);
        graph.querySelector('#third-x-tick').setAttribute('x1', 150 + r / 2);
        graph.querySelector('#third-x-tick').setAttribute('x2', 150 + r / 2);
        graph.querySelector('#forth-x-tick').setAttribute('x1', 150 + r);
        graph.querySelector('#forth-x-tick').setAttribute('x2', 150 + r);
        graph.querySelector('#first-y-tick').setAttribute('y1', 150 - r);
        graph.querySelector('#first-y-tick').setAttribute('y2', 150 - r);
        graph.querySelector('#second-y-tick').setAttribute('y1', 150 - r / 2);
        graph.querySelector('#second-y-tick').setAttribute('y2', 150 - r / 2);
        graph.querySelector('#third-y-tick').setAttribute('y1', 150 + r / 2);
        graph.querySelector('#third-y-tick').setAttribute('y2', 150 + r / 2);
        graph.querySelector('#forth-y-tick').setAttribute('y1', 150 + r);
        graph.querySelector('#forth-y-tick').setAttribute('y2', 150 + r);
        graph.querySelector('#left-r').setAttribute('x', 150 - r - 5);
        graph.querySelector('#right-r').setAttribute('x', 150 + r - 5);
        graph.querySelector('#top-r').setAttribute('y', 150 - r + 5);
        graph.querySelector('#bottom-r').setAttribute('y', 150 + r + 5);
        console.log(graph.querySelector('#circle').style.d)
    }
}
