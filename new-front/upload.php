<div id="drop-area">
    <form class="my-form">
      <div class="form-group">
      <input type="text" class="form-control" id="img_description" placeholder="Beschreibung" >
      </div>
      <input type="file" id="fileElem" multiple accept="image/*" onchange="uploadFile(this.file)">
      <label class="button" for="fileElem">Select a file</label>
      <input id="report-id" value="<?php $id ?>">
    </form>
</div>
