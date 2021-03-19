<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Bidding System</title>
    <style>
      table {
        border-collapse: collapse;
        width: 50%;
        margin-left: auto;
        margin-right: auto;
      }
      th {
        text-align: center;
        border: 1px solid #dddddd;
      }

      td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
      }
      img {
        width: 100%;
        border-radius: 3px;
      }
      .btn {
        display: inline-block;
      }
      button {
        margin: 3px 0;
      }
    </style>
  </head>
  <body>
    <div class="card">
      <table>
        <tr>
          <th>Image</th>
          <th>Description</th>
          <th>Action</th>
        </tr>
        <tr>
          <td>
            <img
              src="https://dynaimage.cdn.cnn.com/cnn/q_auto,w_1100,c_fill,g_auto,h_619,ar_16:9/http%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F200623110902-cheddar-cubes.jpg"
              alt="cheese"
            />
          </td>
          <td>
            <div><b>Product Name:</b>YT Cheese</div>
            <div><b>Type:</b>New</div>
            <div><b>Description:</b>Good for health</div>
          </td>
          <td>
            <span class="btn">
              <button onclick="bid">BID</button>
            </span>
          </td>
        </tr>
      </table>
    </div>
  </body>
</html>
