fetch('/getSessionType')
    .then((response) => response.json())
    .then(function(data) {
        console.log(data);
        if (data && data == 2) {
            window.location.href = "/employee";
        } else if (!data) {
            window.location.href = "/login";
        }
    })

window.onload = function() {
    var table = document.querySelector("#pendingReimbursements");
    fetch('/getPendingReimbursements')
        .then((response) => response.json())
        .then(function(data) {
            console.log(data);
            if(data) {
                for(r of data) {
                    var type;
                    switch(r["type_id"]) {
                        case 1:
                            type = "lodging";
                            break;
                        case 2:
                            type = "travel";
                            break
                        case 3:
                            type = "food";
                            break;
                        case 4:
                            type = "other";
                            break;
                    }
                    var submitted = r["submitted"];
                    if (!r["description"]) {
                        r["description"] = "";
                    }
                    table.innerHTML += `
					<tr>	
						<td>${r["id"]}</td>
						<td>${r["author_id"]}</td>
						<td>${r["amount"]}</td>
						<td>${submitted}</td>
						<td>${r["description"]}</td>
						<td>${type}</td>
						<!--<td> <button class="btn btn-primary container" id="btnResolve">Approve Reimbursement</button>  </td> -->
					</tr>	
					`;
                }
            } else {

            }
        })
}
document.querySelector('#logout').addEventListener('click', function() {
    fetch('/logout');
    window.location.href = "/login";
});
document.querySelector('#all').addEventListener('click', function() {
    window.location.href = "/managerViewAll";
});
var button = document.querySelector('#btnResolve');
button.addEventListener('click', attemptResolve);
function attemptResolve(e) {
    e.preventDefault();
    var id = document.querySelector("#reimbursementID").value;
    var status = document.querySelector("#status").value;
    fetch(`/doResolveReimbursement?id=${id}&status=${status}`)
        .then((response) => response.json())
        .then(function(data) {
            document.querySelector("#status").value = "";
            if(data) {
                window.location.href = "/managerViewAll";
            } else {
                document.querySelector("#unsuccessful").innerText = "Resolution was not successful. Please try again.";
            }
        })

}