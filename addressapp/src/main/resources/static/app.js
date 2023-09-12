$(function(){
  $("#searchKeyword").on("keyup", function () {
    var keyword = $(this).val();
    var endpoint = keyword !== "" ? `/api/search/${keyword}` : "/api/search";
    $.get(endpoint, function (data) {
      var tableBody = $("#customerTableBody");
      tableBody.empty();
      data.forEach(function (customer) {
        tableBody.append(`
          <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.phoneNumber}</td>
            <td>
              <form action="/edit" method="get">
                <input type="hidden" name="id" value="${customer.id}">
                <input class="btn btn-primary" type="submit" value="Edit">
              </form>
            </td>
            <td>
              <form action="/delete" method="post">
                <input type="hidden" name="id" value="${customer.id}">
                <input class="btn btn-primary" type="submit" value="Delete">
              </form>
            </td>
          </tr>
        `);
      });
    });
  });
});
