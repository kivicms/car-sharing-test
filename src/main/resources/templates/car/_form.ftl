<#macro form>
    <form method="post">

        <div class="form-group row">
            <label for="inputVendor" class="col-sm-2 col-form-label">Производитель</label>
            <div class="col-sm-10">
                <select name="vendor" class="form-control">
                    <#list vendorList as vendor>
                        <option value="${vendor.id}" <#if vendor.id == car.getVendorId() > selected="selected"</#if> >
                            ${vendor.name}
                        </option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label for="inputMark" class="col-sm-2 col-form-label">Модель</label>
            <div class="col-sm-10">
                <select name="mark" class="form-control">
                    <#list markList as mark>
                        <option value="${mark.id}" <#if mark.id == car.getMarkId() > selected="selected"</#if> >
                            ${mark.name}
                        </option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label for="inputName" class="col-sm-2 col-form-label">Гос. номер</label>
            <div class="col-sm-10">
                <input type="text" name="number" class="form-control" value="${car.number}" id="inputname"
                       placeholder="Гос. номер">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary my-1">Сохранить</button>
            </div>
        </div>

    </form>
</#macro>