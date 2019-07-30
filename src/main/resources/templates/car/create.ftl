<#import "../layouts/main.ftl" as m>
<@m.page>
<h1>Добавить автомобиль</h1>

<div class="row">
    <div class="col-md-12">

        <form method="post" action="/car/create">

            <div class="form-group row">
                <label for="inputVendor" class="col-sm-2 col-form-label">Производитель</label>
                <div class="col-sm-10">
                    <select name="vendor" class="form-control">
                        <#list vendorList as vendor>
                            <option value="${vendor.id}">${vendor.name}</option>
                        </#list>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label for="inputMark" class="col-sm-2 col-form-label">Модель</label>
                <div class="col-sm-10">
                    <select name="mark" class="form-control">
                        <#list markList as mark>
                            <option value="${mark.id}">${mark.name}</option>
                        </#list>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label for="inputName" class="col-sm-2 col-form-label">Гос. номер</label>
                <div class="col-sm-10">
                    <input type="text" name="number" class="form-control" id="inputname" placeholder="Гос. номер">
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

</@m.page>