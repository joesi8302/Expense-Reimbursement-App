/* create an event listener on click, grabs the id of what was clicked, that id will grab the reimbursment then will populate the modal */

window.addEventListener("load", async () => {
    let response = await fetch("http://localhost:9000/api");
    let result = await response.json();

    console.log(result);
    //go to login if no session is found
    if(!result.successful){
        window.location.href = "../";
    }
    else{
      if(result.data.user_role_id == 1){
        window.location.href = "../employee";
    }
    }

    

    let filterType = document.getElementById("filterType");
    console.log(filterType.value);

    
    switch(filterType.value) {
      case "2":
          populateReimbPending();
          break;
      case "3":
          populateReimbApproved();
          break;
      case "4":
          populateReimbDenied();
          break;
      default:
        populateReimb();
    }
    
})


async function checkSession(){
    let response = await fetch("http://localhost:9000/api");
    let result = await response.json();

    console.log(result.data.ers_password);
    return result;
}

async function logout(){
    await fetch("http://localhost:9000/api" ,{
        method: "DELETE"
    })
    window.location.href = "../";
}

function populateFilter(){

  let filterType = document.getElementById("filterType");


    switch(filterType.value) {
      case "2":
          populateReimbPending();
          break;
      case "3":
          populateReimbApproved();
          break;
      case "4":
          populateReimbDenied();
          break;
      default:
        populateReimb();
    }

}


async function populateReimb(){
    console.log("populate 1 ran")

    let response2 = await fetch(`http://localhost:9000/reimb`);
    let reimbList = await response2.json();


    let reimbContainer = document.getElementById("reimbList");
    reimbContainer.innerHTML = "";


    reimbList.forEach(reimb => {
        let reimbItemElem = document.createElement("tr");

        let status;
        switch(reimb.reimb_status_id) {
            case 2:
                status = "Approved";
              break;
            case 3:
                status = "Denied";
              break;
            default:
              status = "Pending";
          }
        reimbItemElem.id = `reimbID_${reimb.reimb_id}`
     
        reimbItemElem.addEventListener("click", (event) => {
            populateModal(reimbItemElem.id.substring(8));

            let modalContainer = document.getElementById("modal-bodyID");
            modalContainer = "";
            
            reimbItemElem.setAttribute("onclick", "");
            reimbItemElem.setAttribute("data-bs-toggle" , "modal");
            reimbItemElem.setAttribute("data-bs-target", "#exampleModal");
        })


        let resolveBtns = "";
        if(reimb.reimb_status_id == 1){
            resolveBtns = `<button class="btn btn-outline-primary" onclick="approveReimb(${reimb.reimb_id})">Approve</button> <button class="btn btn-outline-danger" onclick="denyReimb(${reimb.reimb_id})">Deny</button>`
        }
        else{
            resolveBtns = "";
        }

        reimbItemElem.innerHTML = `
            <th scope="row">#${reimb.reimb_id}</th>
            <td>$${reimb.reimb_amount}</td>
            <td>${status}</td>
        `
        reimbContainer.appendChild(reimbItemElem);
    })

}

async function populateReimbPending(){

  console.log("populate 2 ran")
  let response2 = await fetch(`http://localhost:9000/reimb`);
  let reimbList = await response2.json();


  let reimbContainer = document.getElementById("reimbList");
  reimbContainer.innerHTML = "";


  reimbList.forEach(reimb => {
    if(reimb.reimb_status_id == 1){
      let reimbItemElem = document.createElement("tr");

      let status;
      switch(reimb.reimb_status_id) {
          case 2:
              status = "Approved";
            break;
          case 3:
              status = "Denied";
            break;
          default:
            status = "Pending";
        }
      reimbItemElem.id = `reimbID_${reimb.reimb_id}`
   
      reimbItemElem.addEventListener("click", (event) => {
          populateModal(reimbItemElem.id.substring(8));

          let modalContainer = document.getElementById("modal-bodyID");
          modalContainer = "";
          
          reimbItemElem.setAttribute("onclick", "");
          reimbItemElem.setAttribute("data-bs-toggle" , "modal");
          reimbItemElem.setAttribute("data-bs-target", "#exampleModal");
      })


      let resolveBtns = "";
      if(reimb.reimb_status_id == 1){
          resolveBtns = `<button class="btn btn-outline-primary" onclick="approveReimb(${reimb.reimb_id})">Approve</button> <button class="btn btn-outline-danger" onclick="denyReimb(${reimb.reimb_id})">Deny</button>`
      }
      else{
          resolveBtns = "";
      }

      reimbItemElem.innerHTML = `
          <th scope="row">#${reimb.reimb_id}</th>
          <td>$${reimb.reimb_amount}</td>
          <td>${status}</td>
      `
      reimbContainer.appendChild(reimbItemElem);
    }
      
  })

}

async function populateReimbApproved(){

  console.log("populate 3 ran")
  let response2 = await fetch(`http://localhost:9000/reimb`);
  let reimbList = await response2.json();


  let reimbContainer = document.getElementById("reimbList");
  reimbContainer.innerHTML = "";


  reimbList.forEach(reimb => {
    if(reimb.reimb_status_id == 2){
      let reimbItemElem = document.createElement("tr");

      let status;
      switch(reimb.reimb_status_id) {
          case 2:
              status = "Approved";
            break;
          case 3:
              status = "Denied";
            break;
          default:
            status = "Pending";
        }
      reimbItemElem.id = `reimbID_${reimb.reimb_id}`
   
      reimbItemElem.addEventListener("click", (event) => {
          populateModal(reimbItemElem.id.substring(8));

          let modalContainer = document.getElementById("modal-bodyID");
          modalContainer = "";
          
          reimbItemElem.setAttribute("onclick", "");
          reimbItemElem.setAttribute("data-bs-toggle" , "modal");
          reimbItemElem.setAttribute("data-bs-target", "#exampleModal");
      })


      let resolveBtns = "";
      if(reimb.reimb_status_id == 1){
          resolveBtns = `<button class="btn btn-outline-primary" onclick="approveReimb(${reimb.reimb_id})">Approve</button> <button class="btn btn-outline-danger" onclick="denyReimb(${reimb.reimb_id})">Deny</button>`
      }
      else{
          resolveBtns = "";
      }

      reimbItemElem.innerHTML = `
          <th scope="row">#${reimb.reimb_id}</th>
          <td>$${reimb.reimb_amount}</td>
          <td>${status}</td>
      `
      reimbContainer.appendChild(reimbItemElem);
    }
      
  })

}

async function populateReimbDenied(){

  console.log("populate 4 ran")

  let response2 = await fetch(`http://localhost:9000/reimb`);
  let reimbList = await response2.json();


  let reimbContainer = document.getElementById("reimbList");
  reimbContainer.innerHTML = "";


  reimbList.forEach(reimb => {
    if(reimb.reimb_status_id == 3){
      let reimbItemElem = document.createElement("tr");

      let status;
      switch(reimb.reimb_status_id) {
          case 2:
              status = "Approved";
            break;
          case 3:
              status = "Denied";
            break;
          default:
            status = "Pending";
        }
      reimbItemElem.id = `reimbID_${reimb.reimb_id}`
   
      reimbItemElem.addEventListener("click", (event) => {
          populateModal(reimbItemElem.id.substring(8));

          let modalContainer = document.getElementById("modal-bodyID");
          modalContainer = "";
          
          reimbItemElem.setAttribute("onclick", "");
          reimbItemElem.setAttribute("data-bs-toggle" , "modal");
          reimbItemElem.setAttribute("data-bs-target", "#exampleModal");
      })


      let resolveBtns = "";
      if(reimb.reimb_status_id == 1){
          resolveBtns = `<button class="btn btn-outline-primary" onclick="approveReimb(${reimb.reimb_id})">Approve</button> <button class="btn btn-outline-danger" onclick="denyReimb(${reimb.reimb_id})">Deny</button>`
      }
      else{
          resolveBtns = "";
      }

      reimbItemElem.innerHTML = `
          <th scope="row">#${reimb.reimb_id}</th>
          <td>$${reimb.reimb_amount}</td>
          <td>${status}</td>
      `
      reimbContainer.appendChild(reimbItemElem);
    }
      
  })

}

async function populateModal(reimb_id){
  
    let response = await fetch(`http://localhost:9000/reimb/${reimb_id}`);
    let result = await response.json();

    let modalContainer = document.getElementById("modal-bodyID");

    let type;
        switch(result.reimb_type_id) {
            case 1:
                type = "LODGING";
              break;
            case 2:
                type = "TRAVEL";
              break;
            case 3:
                type = "FOOD";
              break;
            default:
                type = "OTHER";
          }

    let resolveBtns = "";
    if(result.reimb_status_id == 1){
        resolveBtns = `<button class="btn btn-outline-primary" onclick="approveReimb(${result.reimb_id})">Approve</button> <button class="btn btn-outline-danger" onclick="denyReimb(${result.reimb_id})">Deny</button>`
    }
    else{
        resolveBtns = "";
    }
    
    let modalFooter = document.getElementById("modal-footerID");

    modalFooter.innerHTML = `
        ${resolveBtns}
    `

    modalContainer.innerHTML = `
            <div class="reimbDescription">
                Description: ${result.reimb_description}
            </div>
            <div class="reimbType">
                Reimbursment Type: ${type}
            </div>
            <div class="reimbSubmitted">
            Date Submitted: ${result.reimb_submitted}
            </div>
            <div class="reimbResolved">
            Date Resolved: ${result.reimb_resolved}
            </div>
            <div class="reimbReceipt">
            Receipt: ${result.reimb_receipt}
            </div>
            <div class="reimbResolver">
            Author ID: #${result.reimb_author}
            </div>
            <div class="reimbResolver">
            Resolver ID: #${result.reimb_resolver}
            </div>
    `

}

async function createReimb(event){
    let amountInputElem = document.getElementById("amountInput");
    let descriptionInputElem = document.getElementById("descriptionInput");
    let typeInputElem = document.getElementById("typeInput");

    let response = await fetch("http://localhost:9000/api");
    let result = await response.json();

    let user_id = result.data.ers_user_id;

    let response2 = await fetch("http://localhost:9000/reimb",{
        method: "POST",
        body: JSON.stringify({
            reimb_amount: amountInputElem.value,
            reimb_description: descriptionInputElem.value,
            reimb_author: user_id,
            reimb_type_id: typeInputElem.value
        })
    })

    let result2 = await response2.json(); 

    populateReimb();

}

async function approveReimb(reimb_id){

    let response = await fetch("http://localhost:9000/api");
    let result = await response.json();

    let user_id = result.data.ers_user_id;

    let response2 = await fetch("http://localhost:9000/reimb",{
        method: "PATCH",
        body: JSON.stringify({
            reimb_id: reimb_id,
            reimb_resolver: user_id,
            reimb_type: "approve"
        })
    })
    

    let filterType = document.getElementById("filterType");

    switch(filterType.value) {
      case "2":
          populateReimbPending();
          break;
      case "3":
          populateReimbApproved();
          break;
      case "4":
          populateReimbDenied();
          break;
      default:
        populateReimb();
    }

    

}

async function denyReimb(reimb_id){

    let response = await fetch("http://localhost:9000/api");
    let result = await response.json();

    let user_id = result.data.ers_user_id;

    let response2 = await fetch("http://localhost:9000/reimb",{
        method: "PATCH",
        body: JSON.stringify({
            reimb_id: reimb_id,
            reimb_resolver: user_id,
            reimb_type: "deny"
        })
    })
    

    let filterType = document.getElementById("filterType");


    switch(filterType.value) {
      case "2":
          populateReimbPending();
          break;
      case "3":
          populateReimbApproved();
          break;
      case "4":
          populateReimbDenied();
          break;
      default:
        populateReimb();
    }
    
    
}



/* 
<tr>
              <td>
                <input type="number" id="amountInput" min="0" value="0" step=".01">
              </td>
              <td>
                <input type="text" name="" id="descriptionInput">
              </td>
              <td>
                <select id="typeInput">
                <option value="1">Business</option>
                <option value="2">Travel</option>
                <option value="3">Medical</option>
              </select>
            </td>
            <td>
              <button type="submit"class="btn btn-primary">Submit</button>
            </td>


*/


/* 
<div class="modal-body">
              <div class="reimbDescription">
                Description: 
              </div>
              <div class="reimbSubmitted">
                Date Submitted:
              </div>
              <div class="reimbResolved">
                Date Resolved:
              </div>
              <div class="reimbReceipt">
                Receipt:
              </div>
              <div class="reimbResolver">
                Resolver: 
              </div>
            </div>



*/



/* 
<div class="pageContainer">

        <table class="table">
            <thead>
              <tr >
                <th scope="col">ID</th>
                <th scope="col">Amount</th>
                <th scope="col">Status</th>

              </tr>
            </thead>
            <tbody id="reimbList">
              <tr id="reimbID" onclick: data-bs-toggle="modal" data-bs-target="#exampleModal">
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
              </tr>
              
            </tbody>
          </table>

    </div>


*/