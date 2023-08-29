function getAll() {
    $.ajax({
        type: "GET", // lấy dữ liệu xuống nên dùng type là phương thức Get
        headers: {
            'Accept': 'application/json',   // kiểu dữ liệu là json
        },
        url: "http://localhost:8080/accounts", // url cảu controller
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }

    });
}

getAll()

function show(arr) {
    let str = "";
    for (const a of arr) {
        str += ` <tr>
              <td>${a.id}</td>
              <td>${a.username}</td>
              <td>${a.password}</td>
              <td>${a.role.id}</td>
              <td><button type="button" class="btn btn-warning"  data-toggle="modal" data-target="#modalEdit"
               data-whatever="@mdo" onclick="showEdit(${a.id})" >Edit</button></td>
               
              <td><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalEdit"  data-whatever="@mdo"
               onclick="deleteAccount(${a.id})"  >Delete</button></td>
             </tr>`

    }
    document.getElementById("show").innerHTML = str;
}

function deleteAccount(idA) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/accounts/delete/" + idA,
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function showEdit(idA) { // truyen api sang BE lay ra account co id = idA roi hien thi vao cac  o input de edit
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/accounts/" + idA,
        success: function (data) {
            document.getElementById("idE").value = data.id;
            document.getElementById("usernameE").value = data.username;
            document.getElementById("passwordE").value = data.password;
            document.getElementById("idRoleE").value = data.role.id;

        },
        error: function (err) {
            console.log(err)
        }
    });
}

function editA() {
    let id = document.getElementById("idE").value;
    let username = document.getElementById("usernameE").value;
    let password = document.getElementById("passwordE").value;
    let idRole = document.getElementById("idRoleE").value;

    let account = {id, username, password, role: {id: idRole}};

    $.ajax({
        type: "POST",
        headers: {
            'Content-Type': 'application/json'  // kiểu dữ liệu ajax gửi đi dưới dạng JSon
        },
        url: "http://localhost:8080/accounts",
        data: JSON.stringify(account),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function createA() {

    let username = document.getElementById("usernameA").value;
    let password = document.getElementById("passwordA").value;
    let idRole = document.getElementById("idRoleA").value;

    let account = { username, password, role: {id: idRole}};

    $.ajax({
        type: "POST",
        headers: {
            'Content-Type': 'application/json'  // kiểu dữ liệu ajax gửi đi dưới dạng JSon
        },
        url: "http://localhost:8080/accounts",
        data: JSON.stringify(account),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function searchName() {
    let name = document.getElementById("nameSearch").value;

  if (name === ""){
      getAll()
  }else {
      $.ajax({
          type : "GET",
          headers: {
              'Accept': 'application/json',
          },
          url: "http://localhost:8080/accounts/search/" + name,

          success : function (data) {
              show(data)
          },
          error: function (err) {
              console.log(err)
          }
      });
  }
}
