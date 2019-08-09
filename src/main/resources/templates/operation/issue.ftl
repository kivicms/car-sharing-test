<#import "../layouts/main.ftl" as m>

<@m.page>
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">${pageTitle}</h3>
            <div class="box-tools pull-right">
            </div>
        </div>
        <div class="box-body">
            <form method="post">
                <div class="form-group">
                    <label>Автомобиль</label>
                    <select name="carId" id="carselector" class="form-control">
                        <#list cars as car>
                            <option value="${car.id}">${car.number} / ${car.vendor.name} / ${car.mark.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group">
                    <label>Арендатор</label>
                    <select name="renter" id="renterselector" class="form-control">
                        <#list renters as renter>
                            <option value="${renter.id}">${renter.fio}</option>
                        </#list>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Выдать ТС</button>
            </form>
        </div>
    </div>
</@m.page>