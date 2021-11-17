<html>
  <head>
    <title>Add Content</title>
    <style>
      body {
        margin-left: 0px;
      }
      #add table {
        width: 100%;
        border-collapse: collapse;
        font-size: 20px;
        border: 1px solid #e7e7e7;
      }

      #add td {
        padding-left: 20px;
        width: 80px;
      }
     #add input {
        width: 80%;
        height: 30px;
        margin: 10px 0 10px 0;
        border: 1px solid #e7e7e7;
        border-radius: 5px;
      }
    #add  button {
        margin: 10px 0 20px 0;
        height: 30px;
        border: 1px solid #e7e7e7;
        border-radius: 5px;
        background-color: White;
      }
      #add #brief {
        height: 82px;
       
      }
      #add #content {
        height: 130px;
        
      }#add
     #add .head {
        padding: 10px 0 10px 20px;
        border: 1px solid #e7e7e7;
        background-color: #f8f8f8;
      }
      #add {
        margin-top: 30px;
        margin-left:30px;
      }
    </style>
  </head>
  <body>
    <div style="padding-top:20px ;margin-left:30px;">
      <h1>
        Add Content
      </h1>
    </div>
    <hr style="margin-left:30px" />
    <div id="add">
      <form>
        <table>
          <tr>
            <td class="head">Content form Elements</td>
          </tr>
          <tr>
            <td style="padding-top:20px"><lable><b>Title</b></lable></td>
          </tr>
          <tr>
            <td>
              <input
                type="text"
                id="Title"
                name="title"
                placeholder="Enter the title"
              />
            </td>
          </tr>
          <tr>
            <td><lable><b>Brief</b></lable></td>
          </tr>
          <tr>
            <td><input type="text" id="brief" name="brief" /></td>
          </tr>
          <tr>
            <td><lable><b>Content</b></lable></td>
          </tr>
          <tr>
            <td><input type="text" id="content" name="content" /></td>
          </tr>
          <tr>
            <td>
              <button type="submit" id="submit">Submit button</button>
              <button type="submit" id="reset">
                Reset button
              </button>
            </td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>
	