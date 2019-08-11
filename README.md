# car-sharing-test

### Тестовое задание
В рамках задачи реализован веб-интерфейс к БД MySQL для создания/редактирования/удаления сущностей проекта.

Для того, чтобы приложение имело законченный вид применен шаблон AdminLTE, 
использующий CSS фреймворк bootstrap версии 3. 

Дамп БД, содержащий начальные данные расположен в папке sql.

В БД входят несколько таблиц, а именно:
* vendor - таблица с производителями ТС
* mark - таблица с моделями ТС
* car - таблица транспортных средств
* renter - таблица арендаторов ТС
* operation - операции с ТС (сдача/принятие в аренду) 

### Запуск приложения 
1. mvn install
2. docker-compose up --scale app=3

В результате запустятся следующие контейнеры:
1. БД Mysql
2. Балансировщик нагрузки на nginx
3. 3 контейнера с приложением

### Тестовый сервер с запущенным приложением

http://10.147.56.141/

### API для работы с заданием
1. /vendors - Производители
2. /marks - модели ТС
3. /cars - Транспортные средства
4. /renters - Арендаторы
5. /operations - Операции с ТС

Примеры запросов: 

###### Автомобили http://10.147.56.141/cars

```json
{
  "_embedded": {
    "cars": [
      {
        "number": " Х975СЕ56",
        "status": 1,
        "fullCarName": "Chevrolet / Blazer /  Х975СЕ56",
        "vendorName": "Chevrolet",
        "statusName": "В работе",
        "vendorId": 1,
        "markName": "Blazer",
        "markId": 2,
        "renterFio": "Иванов Виталий Владимирович",
        "_links": {
          "self": {
            "href": "http://10.147.56.141/cars/3"
          },
          "car": {
            "href": "http://10.147.56.141/cars/3"
          },
          "renter": {
            "href": "http://10.147.56.141/cars/3/renter"
          },
          "vendor": {
            "href": "http://10.147.56.141/cars/3/vendor"
          },
          "mark": {
            "href": "http://10.147.56.141/cars/3/mark"
          }
        }
      },
      {
        "number": " 111111111111",
        "status": 0,
        "fullCarName": "Chevrolet / Cobalt /  111111111111",
        "vendorName": "Chevrolet",
        "statusName": "Свободно",
        "vendorId": 1,
        "markName": "Cobalt",
        "markId": 10,
        "renterFio": "Нет",
        "_links": {
          "self": {
            "href": "http://10.147.56.141/cars/14"
          },
          "car": {
            "href": "http://10.147.56.141/cars/14"
          },
          "renter": {
            "href": "http://10.147.56.141/cars/14/renter"
          },
          "vendor": {
            "href": "http://10.147.56.141/cars/14/vendor"
          },
          "mark": {
            "href": "http://10.147.56.141/cars/14/mark"
          }
        }
      },
      {
        "number": " 2323234",
        "status": 1,
        "fullCarName": "Toyota / Camry /  2323234",
        "vendorName": "Toyota",
        "statusName": "В работе",
        "vendorId": 7,
        "markName": "Camry",
        "markId": 11,
        "renterFio": "Фиолетов Транспортир Яблокович",
        "_links": {
          "self": {
            "href": "http://10.147.56.141/cars/15"
          },
          "car": {
            "href": "http://10.147.56.141/cars/15"
          },
          "renter": {
            "href": "http://10.147.56.141/cars/15/renter"
          },
          "vendor": {
            "href": "http://10.147.56.141/cars/15/vendor"
          },
          "mark": {
            "href": "http://10.147.56.141/cars/15/mark"
          }
        }
      },
      {
        "number": " У346РА",
        "status": 1,
        "fullCarName": "Chery / Very /  У346РА",
        "vendorName": "Chery",
        "statusName": "В работе",
        "vendorId": 8,
        "markName": "Very",
        "markId": 12,
        "renterFio": "Иванова Надежда Владимировна",
        "_links": {
          "self": {
            "href": "http://10.147.56.141/cars/16"
          },
          "car": {
            "href": "http://10.147.56.141/cars/16"
          },
          "renter": {
            "href": "http://10.147.56.141/cars/16/renter"
          },
          "vendor": {
            "href": "http://10.147.56.141/cars/16/vendor"
          },
          "mark": {
            "href": "http://10.147.56.141/cars/16/mark"
          }
        }
      },
      {
        "number": " dgdfgdfgfd",
        "status": 1,
        "fullCarName": "Nissan / X-Trail /  dgdfgdfgfd",
        "vendorName": "Nissan",
        "statusName": "В работе",
        "vendorId": 9,
        "markName": "X-Trail",
        "markId": 13,
        "renterFio": "Макаров Макар Макарович",
        "_links": {
          "self": {
            "href": "http://10.147.56.141/cars/17"
          },
          "car": {
            "href": "http://10.147.56.141/cars/17"
          },
          "renter": {
            "href": "http://10.147.56.141/cars/17/renter"
          },
          "vendor": {
            "href": "http://10.147.56.141/cars/17/vendor"
          },
          "mark": {
            "href": "http://10.147.56.141/cars/17/mark"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://10.147.56.141/cars"
    },
    "profile": {
      "href": "http://10.147.56.141/profile/cars"
    }
  }
}
```


##### Операции http://10.147.56.141/operations
```json
{
  "_embedded": {
    "operations": [
      {
        "startDateTime": "2019-08-11T11:19:01",
        "endDateTime": "2019-08-11T11:20:31",
        "_links": {
          "self": {
            "href": "http://10.147.56.141/operations/5"
          },
          "operation": {
            "href": "http://10.147.56.141/operations/5"
          },
          "renter": {
            "href": "http://10.147.56.141/operations/5/renter"
          },
          "car": {
            "href": "http://10.147.56.141/operations/5/car"
          }
        }
      },
      {
        "startDateTime": "2019-08-11T11:19:07",
        "endDateTime": "2019-08-11T11:20:33",
        "_links": {
          "self": {
            "href": "http://10.147.56.141/operations/6"
          },
          "operation": {
            "href": "http://10.147.56.141/operations/6"
          },
          "renter": {
            "href": "http://10.147.56.141/operations/6/renter"
          },
          "car": {
            "href": "http://10.147.56.141/operations/6/car"
          }
        }
      },
      {
        "startDateTime": "2019-08-11T11:23:53",
        "endDateTime": null,
        "_links": {
          "self": {
            "href": "http://10.147.56.141/operations/21"
          },
          "operation": {
            "href": "http://10.147.56.141/operations/21"
          },
          "renter": {
            "href": "http://10.147.56.141/operations/21/renter"
          },
          "car": {
            "href": "http://10.147.56.141/operations/21/car"
          }
        }
      },
      {
        "startDateTime": "2019-08-11T11:24:03",
        "endDateTime": null,
        "_links": {
          "self": {
            "href": "http://10.147.56.141/operations/22"
          },
          "operation": {
            "href": "http://10.147.56.141/operations/22"
          },
          "renter": {
            "href": "http://10.147.56.141/operations/22/renter"
          },
          "car": {
            "href": "http://10.147.56.141/operations/22/car"
          }
        }
      },
      {
        "startDateTime": "2019-08-11T11:24:15",
        "endDateTime": null,
        "_links": {
          "self": {
            "href": "http://10.147.56.141/operations/23"
          },
          "operation": {
            "href": "http://10.147.56.141/operations/23"
          },
          "renter": {
            "href": "http://10.147.56.141/operations/23/renter"
          },
          "car": {
            "href": "http://10.147.56.141/operations/23/car"
          }
        }
      },
      {
        "startDateTime": "2019-08-11T11:24:24",
        "endDateTime": null,
        "_links": {
          "self": {
            "href": "http://10.147.56.141/operations/24"
          },
          "operation": {
            "href": "http://10.147.56.141/operations/24"
          },
          "renter": {
            "href": "http://10.147.56.141/operations/24/renter"
          },
          "car": {
            "href": "http://10.147.56.141/operations/24/car"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://10.147.56.141/operations{?page,size,sort}",
      "templated": true
    },
    "profile": {
      "href": "http://10.147.56.141/profile/operations"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 6,
    "totalPages": 1,
    "number": 0
  }
}
```