<#import "../layouts/main.ftl" as m>
<@m.page>
    <h1>Добавить арендатора</h1>

    <div class="row">
        <div class="col-md-12">

            <form method="post" action="/renter/create">

                <div class="form-group row">
                    <label for="inputFio" class="col-sm-2 col-form-label">ФИО</label>
                    <div class="col-sm-10">
                        <input type="text" name="fio" class="form-control" id="inputFio" placeholder="ФИО">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="inputPassport" class="col-sm-2 col-form-label">Паспорт</label>
                    <div class="col-sm-10">
                        <input type="text" name="passport" class="form-control" id="inputPassport" placeholder="Паспорт">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="inputAddress" class="col-sm-2 col-form-label">Адрес</label>
                    <div class="col-sm-10">
                        <input type="text" name="address" class="form-control" id="inputAddress" placeholder="Адрес">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="inputPhone" class="col-sm-2 col-form-label">Телефон</label>
                    <div class="col-sm-10">
                        <input type="text" name="phone" class="form-control" id="inputPhone" placeholder="Телефон">
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