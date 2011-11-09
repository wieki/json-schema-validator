/*
 * Copyright (c) 2011, Francis Galiegue <fgaliegue@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the Lesser GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.eel.kitchen.jsonschema.keyword;

import org.codehaus.jackson.JsonNode;
import org.eel.kitchen.jsonschema.ValidationReport;
import org.eel.kitchen.jsonschema.context.ValidationContext;

/**
 * Base abstract class for a keyword validator,
 * used by "one shot" validators, ie validators which complete in one step
 * and don't need to spawn further validators.
 */
public abstract class SimpleKeywordValidator
    extends KeywordValidator
{
    /**
     * The schema node used to validate
     */
    protected final JsonNode schema;

    /**
     * Constructor
     *
     * @param context the context to use
     * @param instance the instance to validate
     */
    protected SimpleKeywordValidator(final ValidationContext context,
        final JsonNode instance)
    {
        super(context, instance);
        schema = context.getSchemaNode();
    }

    /**
     * Validate the instance
     */
    protected abstract void validateInstance();

    /**
     * Calls {@link #validateInstance()}, then returns the report
     *
     * @return a {@link ValidationReport}
     */
    @Override
    public final ValidationReport validate()
    {
        validateInstance();
        return report;
    }
}
