<#macro form>

    <div class="row collapse" id="markForm">
        <div class="col-md-12">
            <form method="post" action="/mark/create">

                <div class="form-group row">
                    <label for="inputVendorId" class="col-sm-2 col-form-label">Производитель</label>
                    <div class="col-sm-10">
                        <select name="vendor" class="form-control">
                            <#list vendorList as vendor>
                                <option value="${vendor.id}">${vendor.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="inputName" class="col-sm-2 col-form-label">Модель</label>
                    <div class="col-sm-10">
                        <input type="text" name="name" class="form-control" id="inputname" placeholder="Модель">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary my-1">Добавить</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</#macro>