# ylpparihyppely

[**Aiheen kuvaus**](dokumentaatio/aiheJaRakenne.md)
Pieni tasohyppelypeli rakennettu kokonaan ilman apukirjastoja.

#Dokumentaatio
[Aiheen kuvaus](dokumentaatio/aiheJaRakenne.md)
[Tuntikirjanpito](dokumentaatio/tuntikirjanpito.md)
[Checkstyle](https://htmlpreview.github.io/?https://github.com/Ukonhattu/ylpparihyppely/blob/master/dokumentaatio/site/checkstyle.html)
[Pit](https://htmlpreview.github.io/?https://github.com/Ukonhattu/ylpparihyppely/blob/master/dokumentaatio/pit/201609261212/index.html)

#Ohjeita
Controls: A,D,Space

#Huomioita
**Hitbox ja Physics interface**<br>
Objektilla on aina hitbox, jonka takia jopa Physics perii perii hitboxin. Physics taas on rajapinta, joka tuo GameObjektin toteuttaville luokille fysiikkaan tarvittavat ominaisuudet. Eli hitbox määrittää kaikkia, physics tuo lisää ominaisuuksia.
