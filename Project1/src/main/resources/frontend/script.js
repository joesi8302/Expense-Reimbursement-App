window.addEventListener("load", async () =>{
    let response = await fetch("http://localhost:9000/api");
    let result = await response.json();

    if(result.successful){
        if(result.data.user_role_id == 1)
        window.location.href = "./employee";
        else if (result.data.user_role_id == 2)
        window.location.href = "./manager";
    }
    
})


async function login(e){
    e.preventDefault();
    console.log("login ran");

    let usernameInputElem = document.getElementById("username-input");
    let passwordInputElem = document.getElementById("password-input");

    let failedtext = document.getElementById("failed-text");

    let response = await fetch("http://localhost:9000/api",{
        method: "POST",
        body: JSON.stringify({
            username: usernameInputElem.value,
            password: passwordInputElem.value,
        })
    })
    .catch(err => console.log(err))

    let result = await response.json();

    //this is checking if the login was succesful and redirect to the right page
    if(result.successful){
        if(result.data.user_role_id == 1)
        window.location.href = "./employee";
        else if (result.data.user_role_id == 2)
        window.location.href = "./manager";
    }
    else{
        failedtext.style.display = "block";
    }

    console.log("login ran");

}