const doc = document.getElementById("login-form");

function emailValidation(email) {
    return email.test("/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/")
}

function passwordValidation(password) {
    let result = true;

    if (password.length < 5)
        result = false;
    else if (password.length >= 20)
        result = false;

    return result;
}

function validation(event) {
    let result = true;

    function createError(input, text) {
        const parent = input.parentNode
        let error = document.createElement('label');

        error.textContent = text + " обов'язкова для заповнення"
        parent.append(text);
    }

    form.querySelectorAll('input').forEach(input => {
        filter(input.value !== '' && input.value != null)
            .forEach(input => {
                result = emailValidation(input.mail.value);
                result = emailValidation(input.password.value);
            })
    })

    return;
}

document.getElementById("login-form").addEventListener("submit", function (ev) {

})