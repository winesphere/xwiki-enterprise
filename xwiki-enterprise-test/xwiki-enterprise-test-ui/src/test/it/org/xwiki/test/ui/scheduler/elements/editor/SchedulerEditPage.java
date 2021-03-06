/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.test.ui.scheduler.elements.editor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.xwiki.test.ui.framework.elements.editor.EditPage;
import org.xwiki.test.ui.framework.elements.editor.wysiwyg.EditorElement;
import org.xwiki.test.ui.scheduler.elements.SchedulerPage;

public class SchedulerEditPage extends EditPage
{
    @FindBy(id = "XWiki.SchedulerJobClass_0_jobName")
    private WebElement jobName;

    private final EditorElement jobDescription = new EditorElement("XWiki.SchedulerJobClass_0_jobDescription");

    @FindBy(id = "XWiki.SchedulerJobClass_0_cron")
    private WebElement cron;

    public SchedulerEditPage()
    {
        // Make sure we wait for the WYSIWYG fields to be loaded since otherwise they'll steal the focus and if we
        // start typing in other fields before they're loaded what we type will end up in the wrong fields...
        this.jobDescription.waitToLoad();
    }
    
    public void setJobName(String jobName)
    {
        this.jobName.clear();
        this.jobName.sendKeys(jobName);
    }

    public void setJobDescription(String jobDescription)
    {
        this.jobDescription.getRichTextArea().clear();
        this.jobDescription.getRichTextArea().sendKeys(jobDescription);
    }

    public void setCron(String cron)
    {
        this.cron.clear();
        this.cron.sendKeys(cron);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.xwiki.test.ui.framework.elements.editor.EditPage#clickSaveAndView()
     */
    @Override
    public SchedulerPage clickSaveAndView()
    {
        this.save.click();

        return new SchedulerPage();
    }
}
