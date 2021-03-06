package models

import com.github.stonexx.play.mvc.binders.enum._
import com.github.stonexx.scala.data.OrderedEnumeration
import play.api.libs.json.{Json, OFormat}
import play.api.mvc.{PathBindable, QueryStringBindable}

case class Task(id: Option[Long], label: Option[String])

object Task {
  implicit val jsonFormat: OFormat[Task] = Json.format[Task]

  object forms {
    import play.api.data._
    import play.api.data.Forms._

    val labelForm = Form(
      "label" -> nonEmptyText(maxLength = 20)
    )

    object Sorts extends OrderedEnumeration {
      type Sorts = Value
      val Id    = Value
      val Label = Value

      implicit val pathBindable       : PathBindable[Ordered]        = enumOrderedPathBindable(this)
      implicit val queryStringBindable: QueryStringBindable[Ordered] = enumOrderedQueryStringBindable(this)
    }
  }
}
