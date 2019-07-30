<#macro form>

    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#markForm"
            aria-expanded="false" aria-controls="collapseExample">
        Добавить производителя
    </button>
    <div class="row collapse" id="markForm">
        <div class="col-md-12">
            <form method="post" action="/vendor/create">

                <div class="form-group row">
                    <label for="inputName" class="col-sm-2 col-form-label">Производитель</label>
                    <div class="col-sm-10">
                        <input type="text" name="name" class="form-control" id="inputname" placeholder="Производитель">
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