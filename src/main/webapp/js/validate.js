form = document.querySelector('#input-form');
let xField = form.querySelector('#x');
let yField = form.querySelector('#y');
let rField = form.querySelector('#r');

function validate() {
    return validateX() & validateY() & validateR();
}

function validateX() {
    xField.parentElement.parentElement.querySelector('.error').innerHTML = '';
    xField.valid = false;
    if (!validateField(xField.value)) {
        xField.parentElement.parentElement.querySelector('.error').innerHTML = 'Cannot be blank';
        return false;
    }
    else if (!validateNumber(xField.value)) {
        xField.parentElement.parentElement.querySelector('.error').innerHTML = 'Should be a number';
        return false;
    }
    else if (!validateRange(xField.value, -5, 3)) {
        xField.parentElement.parentElement.querySelector('.error').innerHTML = 'Should be in (-5;3)';
        return false;
    }
    xField.valid = true;
    return true;
}

function validateY() {
    yField.parentElement.parentElement.querySelector('.error').innerHTML = '';
    if (!validateField(yField.value)) {
        yField.parentElement.parentElement.querySelector('.error').innerHTML = 'Cannot be blank';
        return false;
    }
    else if (!validateNumber(yField.value)) {
        yField.parentElement.parentElement.querySelector('.error').innerHTML = 'Should be a number';
        return false;
    }
    else if (!validateRange(yField.value, -5, 3)) {
        yField.parentElement.parentElement.querySelector('.error').innerHTML = 'Should be in (-5;3)';
        return false;
    }
    return true;
}

function validateR() {
    rField.parentElement.parentElement.querySelector('.error').innerHTML = '';
    if (!validateField(rField.value)) {
        rField.parentElement.parentElement.querySelector('.error').innerHTML = 'Cannot be blank';
        return false;
    }
    else if (!validateNumber(rField.value)) {
        rField.parentElement.parentElement.querySelector('.error').innerHTML = 'Should be a number';
        return false;
    }
    else if (!validateRange(rField.value, 1, 4)) {
        rField.parentElement.parentElement.querySelector('.error').innerHTML = 'Should be in (1;4)';
        return false;
    }
    return true;
}

function validateField(value) {
    return value;
}

function validateNumber(value) {
    return isFinite(value);
}

function validateRange(value, min, max) {
    return value > min && value < max;
}


