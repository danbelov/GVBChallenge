<div id="drop-area">
    <form class="my-form">
      <div class="form-group">
      <input type="text" class="form-control" id="img_description" placeholder="Beschreibung" >
      </div>
      <input type="file" id="fileElem" multiple accept="image/*" onchange="handleFile(this.files)">
      <label class="button" for="fileElem">Select a file</label>
      <input id="report-id" value="<?php $id ?>">
      <div id="gallery"></div>
    </form>
</div>
