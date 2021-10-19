package com.example.ladm_u2_practica1_diademuertos


import android.graphics.*
import android.os.CountDownTimer
import android.view.View


class Lienzo(p: MainActivity): View(p) {
    //VARIABLES PARA TIMER 1
    var calx1=-280f
    var caly1=1180f
    var incrementoX1 = 3

    //VARIABLES PARA TIMER 2
    var calx2=1050f
    var caly2=1550f
    var incrementoX2 = 3

    //VARIABLES PARA TIMER 4
    var calx3=650f
    var caly3=850f
    var incrementoX3 = 3

    //VARIABLES PARA TIMER 3
    var imax=445f
    var imay=-2000f
    var incrementoim=0.02f

    var xC = 170f
    var yC = 200f

    var xC2 = 1100f
    var yC2 = 200f


    //ESQUELETOS DE IZQUIERDA A DERECHA
    val esqueleto2 = BitmapFactory.decodeResource(resources, R.drawable.catri)
    val esqueleto3 = BitmapFactory.decodeResource(resources, R.drawable.esqueleto)

    //TEMPLO
    val altar = BitmapFactory.decodeResource(resources, R.drawable.altarr)
    //TUMBAS

    val tummba = BitmapFactory.decodeResource(resources, R.drawable.lappid)


    val florcc = BitmapFactory.decodeResource(resources, R.drawable.florcruz)
    val vella = BitmapFactory.decodeResource(resources, R.drawable.veladora)
    val florcem = BitmapFactory.decodeResource(resources, R.drawable.florcemp)
    val mex = BitmapFactory.decodeResource(resources, R.drawable.cal)



    //ESQUELETOS DE ARRIBA HACIA ABAJO
    val esqueleto = BitmapFactory.decodeResource(resources, R.drawable.lloronaa)

    //ESPECIFICACIONES DEL ESQUELETO2 EN EL TIMER
    var rcal1= Bitmap.createScaledBitmap(esqueleto3, 200, 200, true /* filter*/)
    var rcal2= Bitmap.createScaledBitmap(esqueleto2, 200, 200, true /* filter*/)
    var rcal3= Bitmap.createScaledBitmap(esqueleto2, 200, 200, true /* filter*/)

    //ESPECIFICACIONES DEL ESQUELETO EN EL TIMER
    var rcal4= Bitmap.createScaledBitmap(esqueleto, 200, 200, true /* filter*/)

    //ESPECIFICACIONES DE flor
    var rcal5= Bitmap.createScaledBitmap(florcem, 80, 80, true /* filter*/)

    //ADORNOS
    var mx= Bitmap.createScaledBitmap(mex, 200, 200, true /* filter*/)
    var florc= Bitmap.createScaledBitmap(florcc, 400, 400, true /* filter*/)
    //ESPECIFICACIONES DE ALTAR
    var alttar= Bitmap.createScaledBitmap(altar, 400, 400, true /* filter*/)


    //ESPECIFICACION DE LAPIDAS
    var tumba= Bitmap.createScaledBitmap(tummba, 200, 200, true /* filter*/)

    //TIMER'S DE LAS IMAGENES
    val timer = object : CountDownTimer(2000000, 200000){
        override fun onTick(millisUntilFinished: Long) {
            calx1+=incrementoX1
            if(calx1<=-700||calx1>=1200)
            {
                incrementoX1 *=-1
            }
        }
        override fun onFinish() {
            start()
        }
    }

    val timer2 = object : CountDownTimer(2000000, 200000){
        override fun onTick(millisUntilFinished: Long) {
            calx2+=incrementoX2
            if(calx2<=-700||calx2>=1200)
            {
                incrementoX2 *=-1
            }
        }
        override fun onFinish() {
            start()
        }
    }

    val timer4 = object : CountDownTimer(2000000, 200000){
        override fun onTick(millisUntilFinished: Long) {
            calx3+=incrementoX3
            if(calx3<=-700||calx3>=1200)
            {
                incrementoX3 *=-1
            }
        }
        override fun onFinish() {
            start()
        }
    }

    val timer3 = object : CountDownTimer(20000,1000){
        override fun onTick(millisUntilFinished: Long) {
            imay+=incrementoim
            invalidate()
        }
        override fun onFinish() {
            start()
            if(incrementoim>100)
            {
                this.cancel()
            }
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        val p= Paint()

        //FONDO DEL CIELO
        c.drawARGB(255, 11, 18, 33)

        //Cielo
        //Luna
        p.setColor(Color.argb(255, 227, 231, 238))
        c.drawCircle(950f, 130f, 110f, p)
        // p.setColor(Color.argb(255, 3, 19, 79))
        p.setColor(Color.argb(255, 11, 18, 33))
        c.drawCircle(1070f, 70f, 150f, p)

        //NUBES
        //NUBE DERECHA - DELANTERA
        p.setColor(Color.argb(255, 155, 155, 155))
        c.drawCircle(xC2, yC2 + 50, 80f, p)
        c.drawCircle(xC2 - 90, yC2 + 100, 80f, p)
        c.drawCircle(xC2 + 90, yC2 + 100, 80f, p)
        c.drawCircle(xC2, yC2 + 100, 80f, p)


        //NUBE  SOMBRA
        p.setColor(Color.argb(255, 130, 130, 130))
        c.drawCircle(xC2 - 290, yC2 + 80, 90f, p)
        c.drawCircle(xC2 - 390, yC2 + 75, 70f, p)
        c.drawCircle(xC2 - 190, yC2 + 75, 70f, p)
        c.drawCircle(xC2 - 290, yC2 + 40, 90f, p)
        //NUBE - DELANTERA
        p.setColor(Color.argb(255, 155, 155, 155))
        c.drawCircle(xC2 - 290, yC2 + 100, 70f, p)
        c.drawCircle(xC2 - 390, yC2 + 120, 70f, p)
        c.drawCircle(xC2 - 190, yC2 + 120, 60f, p)
        c.drawCircle(xC2 - 290, yC2 + 120, 70f, p)


        //ALTAR
        c.drawBitmap(alttar, 350f, 300f, p)



        //TIERRA FILA DE TUMBAS
        p.setColor(Color.argb(255, 50, 52, 40))
        c.drawRect(630f, 690f, 1080f, 2000f, p)//Camino derecho
        c.drawRect(0f, 690f, 460f, 2000f, p)//Camino izquierdo
        //CAMINO HACIA EL TEMPLO
        p.setColor(Color.argb(255, 50, 52, 40))
        c.drawRect(460f, 690f, 630f, 2000f, p)//camino de cempasuchil

        //veladoras
        c.drawBitmap(vella, 620f, 700f, p)
        c.drawBitmap(vella, 415f, 700f, p)
        c.drawBitmap(vella, 620f, 800f, p)
        c.drawBitmap(vella, 415f, 800f, p)
        c.drawBitmap(vella, 620f, 900f, p)
        c.drawBitmap(vella, 415f, 900f, p)
        c.drawBitmap(vella, 620f, 1100f, p)
        c.drawBitmap(vella, 415f, 1100f, p)
        c.drawBitmap(vella, 620f, 1300f, p)
        c.drawBitmap(vella, 415f, 1300f, p)
        c.drawBitmap(vella, 620f, 1500f, p)
        c.drawBitmap(vella, 415f, 1500f, p)
        c.drawBitmap(vella, 620f, 1700f, p)
        c.drawBitmap(vella, 415f, 1700f, p)
        c.drawBitmap(vella, 620f, 1900f, p)
        c.drawBitmap(vella, 415f, 1900f, p)
        c.drawBitmap(vella, 620f, 1200f, p)
        c.drawBitmap(vella, 415f, 1200f, p)
        c.drawBitmap(vella, 620f, 1400f, p)
        c.drawBitmap(vella, 415f, 1400f, p)
        c.drawBitmap(vella, 620f, 1600f, p)
        c.drawBitmap(vella, 415f, 1600f, p)
        c.drawBitmap(vella, 620f, 1800f, p)
        c.drawBitmap(vella, 415f, 1800f, p)
        c.drawBitmap(vella, 620f, 2000f, p)
        c.drawBitmap(vella, 415f, 2000f, p)

        //FLORES
        c.drawBitmap(rcal5, 0f, 630f, p)
        c.drawBitmap(rcal5, 60f, 630f, p)
        c.drawBitmap(rcal5, 120f, 630f, p)
        c.drawBitmap(rcal5, 180f, 630f, p)

        c.drawBitmap(rcal5, 850f, 630f, p)
        c.drawBitmap(rcal5, 910f, 630f, p)
        c.drawBitmap(rcal5, 970f, 630f, p)
        c.drawBitmap(rcal5, 1020f, 630f, p)

        //alebrije/mex

        c.drawBitmap(mx, 700f, 510f, p)
        c.drawBitmap(mx, 200f, 510f, p)


        //PRIMERA FILA DE TUMBAS
        c.drawBitmap(tumba, 265f, 800f, p)
        c.drawBitmap(tumba, 0f, 800f, p)
        c.drawBitmap(tumba, 920f, 800f, p)
        c.drawBitmap(tumba, 660f, 800f, p)

        c.drawBitmap(florc, 370f, 900f, p)

        //SEGUNDA FILA DE TUMBAS
        c.drawBitmap(tumba, 265f, 1100f, p)
        c.drawBitmap(tumba, 0f, 1100f, p)
        c.drawBitmap(tumba, 920f, 1100f, p)
        c.drawBitmap(tumba, 660f, 1100f, p)

        //TERCERA FILA DE TUMBAS
        c.drawBitmap(tumba, 265f, 1400f, p)
        c.drawBitmap(tumba, 0f, 1400f, p)
        c.drawBitmap(tumba, 920f, 1400f, p)
        c.drawBitmap(tumba, 660f, 1400f, p)

        //CUARTA FILA DE TUMBAS
        c.drawBitmap(tumba, 265f, 1700f, p)
        c.drawBitmap(tumba, 0f, 1700f, p)
        c.drawBitmap(tumba, 920f, 1700f, p)
        c.drawBitmap(tumba, 660f, 1700f, p)

        //ESQUELETOS
        c.drawBitmap(rcal2,calx2,caly2,p)
        c.drawBitmap(rcal3,calx3,caly3,p)
        c.drawBitmap(rcal1,calx1,caly1,p)
        c.drawBitmap(rcal4,imax,imay,p)

        //ACTIVAR TIMER PARA LA ANIMACION
        timer.start()
        timer2.start()
        timer4.start()
        timer3.start()

    }


}